package com.example.tugasil.mode

import com.example.tugasil.data.DataConf
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tugasil.`interface`.screen.detail.DetailViewModel
import com.example.tugasil.`interface`.screen.grup.GrupViewModel
import com.example.tugasil.`interface`.screen.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataMod = module {
    single { DataConf() }
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { GrupViewModel(get()) }
}