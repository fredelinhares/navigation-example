package com.example.featureb

import org.koin.dsl.module

val featureBModule = module {

    factory<FeatureBContract.Presenter> { (view: FeatureBContract.View, navigation: FeatureBNavigation) ->
        FeatureBPresenter(view, navigation)
    }

}