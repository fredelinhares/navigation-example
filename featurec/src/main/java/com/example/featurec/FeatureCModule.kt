package com.example.featurec


import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureCModule = module {
    viewModel { (navigation: FeatureCNavigation) -> FeatureCViewModel(navigation) }
}