package com.example.aroapp.ui.main

import androidx.lifecycle.ViewModel
import com.example.aroapp.data.repos.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepo: MainRepo): ViewModel() {
}