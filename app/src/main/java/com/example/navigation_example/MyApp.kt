package com.example.navigation_example

import android.app.Application
import com.example.featurea.featureAModule
import com.example.featureb.featureBModule
import com.example.featurec.featureCModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(
                appModule,
                featureAModule,
                featureBModule,
                featureCModule
            )
        }
    }
}
