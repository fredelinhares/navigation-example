package com.example.navigation_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.featurea.FeatureAFragment
import com.example.featurea.FeatureANavigation
import com.example.featureb.FeatureBFragment
import com.example.featureb.FeatureBNavigation
import com.example.featurec.FeatureCFragment
import com.example.featurec.FeatureCNavigation
import com.example.navigation_example.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), AppContract.View, FeatureANavigation, FeatureBNavigation,
    FeatureCNavigation {
    private lateinit var binding: ActivityMainBinding

    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }

    private val navController: NavController
        get() = navHostFragment.navController.apply {
            setGraph(R.navigation.main_nav_graph)
        }

    private val presenter: AppContract.Presenter by inject()

    private val featureAFragment by lazy { FeatureAFragment.newInstance() }
    private val featureBFragment by lazy { FeatureBFragment.newInstance() }
    private val featureCFragment by lazy { FeatureCFragment.newInstance() }

    private val manualNavigationFragment by lazy { ManualNavigationFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.nav_host_fragment, featureAFragment, "FeatureA")
            .add(R.id.nav_host_fragment, featureBFragment, "FeatureB")
            .add(R.id.nav_host_fragment, featureCFragment, "FeatureC")
            .add(R.id.nav_host_fragment, manualNavigationFragment, "ManualNavigation")
            .hide(featureBFragment)
            .hide(featureCFragment)
            .commit()

        presenter.onViewCreated(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun navigateFromAToB() {
        manualNavigationFragment.navigateFromAToB()
    }

    override fun navigateFromBToA() {
        manualNavigationFragment.navigateFromBToA()
    }

    override fun navigateFromAToC() {
        manualNavigationFragment.navigateFromAToC()
    }

    override fun navigateFromCToA() {
        manualNavigationFragment.navigateFromCToA()
    }

    override fun navigateFromBToC() {
        manualNavigationFragment.navigateFromBToC()
    }

    override fun navigateFromCToB() {
        manualNavigationFragment.navigateFromCToB()
    }

    override fun navigateToFeatureB() {}
}


