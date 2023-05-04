package com.example.navigation_example

class AppPresenter : AppContract.Presenter {
    private lateinit var view: AppContract.View

    override fun onViewCreated(view: AppContract.View) {
        this.view = view
    }
}
