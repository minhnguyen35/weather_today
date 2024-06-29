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

    override suspend fun doWork(params: Params) {
        val syncInformation = syncInformationRepository.getAttribute(SYNC_TIME).firstOrNull()

        println("nhbm lastSyncTime = ${syncInformation?.value}")
        if (syncInformation == null || syncInformation.valueType == "Long") {
            val current: Long = System.currentTimeMillis()
            val lastSyncTime = syncInformation?.value?.toLong() ?: 0L
            val gapTime = current - lastSyncTime
            val threshold = TimeUnit.HOURS.toMillis(12)
            println("nhbm gapTime = $gapTime threshold = $threshold")
            if (gapTime >= threshold) {
                val isSyncedSuccessfully = forecastsByCityRepository.syncData(params.city)
                if(isSyncedSuccessfully) {
                    println("nhbm sync new data")
                    syncInformationRepository.saveAttribute(
                        attribute = SYNC_TIME,
                        value = current
                    )
                }
            }
        }

    }

    data class Params(val city: String)
}