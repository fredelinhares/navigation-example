package com.example.featurea

class FeatureAPresenter(
    private val view: FeatureAContract.View,
    private val navigation: FeatureANavigation
) : FeatureAContract.Presenter {
    override fun onViewCreated() {
        view.showMessage("Feature A created")
    }
    override fun onFeatureBNavigationRequested() {
        navigation.navigateFromAToB()
    }

    override fun onFeatureCNavigationRequested() {
        navigation.navigateFromAToC()
    }
}
