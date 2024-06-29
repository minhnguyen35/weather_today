package com.minhnguyen.domain.interactors

import com.example.legacy.mappers.withRetry
import com.minhnguyen.domain.Interactor
import com.minhnguyen.forecasts.ForecastsByCityRepository
import java.util.Calendar
import javax.inject.Inject

class DeleteOutdatedCache @Inject constructor(
    private val forecastsByCityRepository: ForecastsByCityRepository,
    ): Interactor<Unit>() {
    override suspend fun doWork(params: Unit) {
        var currentTime = System.currentTimeMillis()
        val offset = Calendar.getInstance().timeZone.getOffset(currentTime)
        currentTime /= 1000
        currentTime -= offset*3600
        withRetry {
            val totalItems = forecastsByCityRepository.deleteOutdatedData(currentTime)
            println("nhbm totalDeletedItems = $totalItems")
        }
    }
}