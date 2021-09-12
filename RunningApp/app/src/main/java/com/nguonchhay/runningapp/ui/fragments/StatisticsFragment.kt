package com.nguonchhay.runningapp.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nguonchhay.runningapp.R
import com.nguonchhay.runningapp.ui.viewmodels.MainViewModel
import com.nguonchhay.runningapp.ui.viewmodels.StatisticsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatisticsFragment : Fragment(R.layout.fragment_tracking) {

    private val viewModel: StatisticsViewModel by viewModels()
}