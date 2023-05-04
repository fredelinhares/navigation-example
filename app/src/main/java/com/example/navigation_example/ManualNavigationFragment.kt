package com.example.navigation_example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.featurea.FeatureAFragment
import com.example.featureb.FeatureBFragment
import com.example.featurec.FeatureCFragment

class ManualNavigationFragment : Fragment() {

    private lateinit var navController: NavController
    private val featureAFragment by lazy { FeatureAFragment.newInstance() }
    private val featureBFragment by lazy { FeatureBFragment.newInstance() }
    private val featureCFragment by lazy { FeatureCFragment.newInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_manual_navigation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController =
            Navigation.findNavController(requireActivity(), R.id.manual_navigation_container)
    }

    fun navigateFromAToB() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, FeatureBFragment.newInstance(), "FeatureB")
            .addToBackStack(null)
            .commit()
    }

    fun navigateFromBToA() {
        parentFragmentManager.beginTransaction()
            .hide(featureAFragment)
            .show(featureBFragment)
            .commit()
    }

    fun navigateFromAToC() {
        // Use this method to navigate to FeatureC
        navController.navigate(R.id.action_global_featureCFragment)
    }

    fun navigateFromCToA() {
        // Use this method to navigate to FeatureA
        navController.navigate(R.id.action_global_featureAFragment)
    }

    private var pendingTransaction: Runnable? = null


    fun navigateFromBToC() {
        if (!childFragmentManager.isStateSaved) {
            childFragmentManager.beginTransaction()
                .hide(featureBFragment)
                .show(featureCFragment)
                .runOnCommit {
                    pendingTransaction = null
                }
                .commit()
        } else {
            pendingTransaction = Runnable {
                navigateFromBToC()
            }
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (pendingTransaction != null) {
            pendingTransaction!!.run()
        }
    }

    fun navigateFromCToB() {
        childFragmentManager.beginTransaction()
            .hide(featureCFragment)
            .show(featureBFragment)
            .commit()
    }

}
