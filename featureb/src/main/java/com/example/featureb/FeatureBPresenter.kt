package com.example.featureb

class FeatureBPresenter(
    private val view: FeatureBContract.View,
    private val navigation: FeatureBNavigation
) : FeatureBContract.Presenter {
    override fun onViewCreated() {
        view.showMessage("Feature B created")
    }

    override fun onFeatureANavigationRequested() {
        navigation.navigateFromBToA()
    }

    override fun onFeatureCNavigationRequested() {
        navigation.navigateFromBToC()
    }
}