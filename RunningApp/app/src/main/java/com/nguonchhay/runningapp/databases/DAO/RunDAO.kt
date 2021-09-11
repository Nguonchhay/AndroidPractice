package com.nguonchhay.runningapp.databases.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nguonchhay.runningapp.databases.models.Run

@Dao
interface RunDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM runs ORDER BY timestamp DESC")
    fun getRunsSortByDate(): LiveData<MutableList<Run>>

    @Query("SELECT * FROM runs ORDER BY avgSpeedInKMH DESC")
    fun getRunsSortByAverageSpeed(): LiveData<MutableList<Run>>

    @Query("SELECT * FROM runs ORDER BY distanceInMeters DESC")
    fun getRunsSortByDistance(): LiveData<MutableList<Run>>

    @Query("SELECT * FROM runs ORDER BY timeInMilli DESC")
    fun getRunsSortByTime(): LiveData<MutableList<Run>>

    @Query("SELECT * FROM runs ORDER BY caloriesBurned DESC")
    fun getRunsSortByCaloriesBurned(): LiveData<MutableList<Run>>

    @Query("SELECT AVG(avgSpeedInKMH) as total FROM runs")
    fun getTotalAverageSpeed(): LiveData<Float>

    @Query("SELECT SUM(distanceInMeters) as total FROM runs")
    fun getTotalTDistance(): LiveData<Int>

    @Query("SELECT SUM(timeInMilli) as total FROM runs")
    fun getTotalTimeInMillis(): LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) as total FROM runs")
    fun getTotalCaloriesBurned(): LiveData<Int>

}