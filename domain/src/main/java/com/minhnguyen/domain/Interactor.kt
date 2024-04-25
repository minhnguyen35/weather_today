package com.minhnguyen.domain

import com.example.base.InvokeError
import com.example.base.InvokeStarted
import com.example.base.InvokeStatus
import com.example.base.InvokeSuccess
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.withTimeout
import java.util.concurrent.TimeUnit

abstract class Interactor<in P>{
    operator fun invoke(
        params: P,
        timeoutMs: Long = defaultTimeoutMs
    ): Flow<InvokeStatus> = flow {
        try {
            withTimeout(timeoutMs) {
                emit(InvokeStarted)
                doWork(params)
                emit(InvokeSuccess)
            }
        }catch (t: TimeoutCancellationException) {
            emit(InvokeError(t))
        }
    }.catch { t -> emit(InvokeError(t)) }

    suspend fun executeSync(params: P) = doWork(params)
    protected abstract suspend fun doWork(params: P)

    companion object {
        private val defaultTimeoutMs = TimeUnit.MINUTES.toMillis(5)
    }
}

suspend inline fun Interactor<Unit>.executeSync() = executeSync(Unit)

abstract class ResultInteractor<in P, R> {
    operator fun invoke(params: P): Flow<R> = flow {
        emit(doWork(params))
    }

    suspend fun executeSync(params: P): R = doWork(params)

    protected abstract suspend fun doWork(params: P): R
}

suspend inline fun<R> ResultInteractor<Unit, R>.executeSync(): R = executeSync(Unit)

abstract class SubjectInteractor<P: Any, T> {
    private val paramState = MutableSharedFlow<P>(
        replay = 1,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    val flow: Flow<T> = paramState
        .distinctUntilChanged()
        .flatMapLatest {
            createObservable(it)
        }
        .distinctUntilChanged()

    operator fun invoke(params: P) {
        paramState.tryEmit(params)
    }
    protected abstract fun createObservable(params: P): Flow<T>
}