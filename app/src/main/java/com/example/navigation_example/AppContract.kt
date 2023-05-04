package com.example.navigation_example


interface AppContract {
    interface View {
        fun navigateToFeatureB()
    }

    interface Presenter {
        fun onViewCreated(view: View)
    }
}
