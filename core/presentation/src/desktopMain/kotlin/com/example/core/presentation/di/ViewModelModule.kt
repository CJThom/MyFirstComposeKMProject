package com.example.core.presentation.di

import com.example.core.presentation.MyFirstKMViewModel
import org.koin.dsl.module

actual fun viewModelModule() = module {
    factory { MyFirstKMViewModel(get(), get()) }
}
