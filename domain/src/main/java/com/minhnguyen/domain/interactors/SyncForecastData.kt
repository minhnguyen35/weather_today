package com.minhnguyen.domain.interactors

import android.util.TimeUtils
import com.minhnguyen.domain.Interactor
import com.minhnguyen.forecasts.ForecastsByCityRepository
import com.minhnguyen.syncinformation.SyncInformationRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.firstOrNull
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SyncForecastData @Inject constructor(
    private val forecastsByCityRepository: ForecastsByCityRepository,
    private val syncInformationRepository: SyncInformationRepository
) : Interactor<SyncForecastData.Params>() {
    companion object {
        private const val SYNC_TIME = "sync_time"
    }

    init {
        println("mnguyen onCreate SyncForecastData")
    }

    override suspend fun doWork(params: Params) {
        val syncInformation = syncInformationRepository.getAttribute(SYNC_TIME).firstOrNull()

        println("nhbm lastSyncTime = ${syncInformation?.value}")
        if (syncInformation == null || syncInformation.valueType == "Long") {
            val current: Long = System.currentTimeMillis()
            val lastSyncTime = syncInformation?.value?.toLong() ?: 0L
            val gapTime = current - lastSyncTime
            println("nhbm gapTime = $gapTime")
            if (gapTime >= TimeUnit.DAYS.toMillis(5)) {
                println("nhbm sync new data")
                syncInformationRepository.saveAttribute(
                    attribute = SYNC_TIME,
                    value = current
                )
                forecastsByCityRepository.syncData(params.city)
            }
        }

    }

    data class Params(val city: String)
}