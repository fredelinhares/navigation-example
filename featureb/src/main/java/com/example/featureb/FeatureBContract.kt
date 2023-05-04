package com.example.featureb

interface FeatureBContract {
    interface View {
        fun showMessage(message: String)
    }

    interface Presenter {
        fun onViewCreated()
        fun onFeatureANavigationRequested()
        fun onFeatureCNavigationRequested()
    }
}
