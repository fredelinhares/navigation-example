package com.example.featurea

interface FeatureAContract {
    interface View {
        fun showMessage(message: String)
    }

    interface Presenter {
        fun onViewCreated()
        fun onFeatureBNavigationRequested()
        fun onFeatureCNavigationRequested()
    }
}

