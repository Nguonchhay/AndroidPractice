package com.nguonchhay.runningapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.nguonchhay.runningapp.databases.repositories.RunRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (
    val runRepository: RunRepository
) : ViewModel()  {
}