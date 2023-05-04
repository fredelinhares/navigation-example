package com.example.navigation_example

import org.koin.dsl.module

val appModule = module {
    factory<AppContract.Presenter> { AppPresenter() }
}