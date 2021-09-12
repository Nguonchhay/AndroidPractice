package com.nguonchhay.runningapp.databases.repositories

import androidx.lifecycle.LiveData
import com.nguonchhay.runningapp.databases.DAO.RunDAO
import com.nguonchhay.runningapp.databases.models.Run
import javax.inject.Inject

class RunRepository @Inject constructor(
    val runDAO: RunDAO
) {
    suspend fun insertRun(run: Run) = runDAO.insertRun(run)

    suspend fun deleteRun(run: Run) = runDAO.deleteRun(run)

    suspend fun getRunsSortByDate(): LiveData<MutableList<Run>> = runDAO.getRunsSortByDate()

    suspend fun getRunsSortByAverageSpeed(): LiveData<MutableList<Run>> = runDAO.getRunsSortByAverageSpeed()

    suspend fun getRunsSortByDistance(): LiveData<MutableList<Run>> = runDAO.getRunsSortByDistance()

    suspend fun getRunsSortByTime(): LiveData<MutableList<Run>> = runDAO.getRunsSortByTime()

    suspend fun getRunsSortByCaloriesBurned(): LiveData<MutableList<Run>> = runDAO.getRunsSortByCaloriesBurned()

    suspend fun getTotalAverageSpeed(): LiveData<Float> = runDAO.getTotalAverageSpeed()

    suspend fun getTotalTDistance(): LiveData<Int> = runDAO.getTotalTDistance()

    suspend fun getTotalTimeInMillis(): LiveData<Long> = runDAO.getTotalTimeInMillis()

    suspend fun getTotalCaloriesBurned(): LiveData<Int> = runDAO.getTotalCaloriesBurned()

}