package com.example.featurea

import org.koin.dsl.module

val featureAModule = module {

    factory { (navigation: FeatureANavigation) -> FeatureAPresenter(get(), navigation) }

    factory<FeatureAContract.Presenter> { (view: FeatureAContract.View, navigation: FeatureANavigation) ->
        FeatureAPresenter(view, navigation)
    }

}