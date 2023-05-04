package com.example.navigation_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.featurea.FeatureANavigation
import com.example.featureb.FeatureBNavigation
import com.example.featurec.FeatureCNavigation
import com.example.navigation_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),  FeatureANavigation, FeatureBNavigation,
    FeatureCNavigation {
    private lateinit var binding: ActivityMainBinding
    private fun navigateToFeatureA() = navController.navigate(R.id.action_global_featureAFragment)
    private fun navigateToFeatureB() = navController.navigate(R.id.action_global_featureBFragment)
    private fun navigateToFeatureC() = navController.navigate(R.id.action_global_featureCFragment)

    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }

    private val navController: NavController
        get() = navHostFragment.navController.apply {
            setGraph(R.navigation.main_nav_graph)
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun navigateFromAToB() = navigateToFeatureB()
    override fun navigateFromCToB() = navigateToFeatureB()
    override fun navigateFromAToC() = navigateToFeatureC()
    override fun navigateFromBToC() = navigateToFeatureC()
    override fun navigateFromBToA() = navigateToFeatureA()
    override fun navigateFromCToA() = navigateToFeatureA()
}


