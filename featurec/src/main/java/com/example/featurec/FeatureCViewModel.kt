package com.example.featurec

import androidx.lifecycle.ViewModel

class FeatureCViewModel(private val navigation: FeatureCNavigation) : ViewModel() {

    fun onFeatureANavigationRequested() {
        navigation.navigateFromCToA()
    }

    fun onFeatureBNavigationRequested() {
        navigation.navigateFromCToB()
    }
}
