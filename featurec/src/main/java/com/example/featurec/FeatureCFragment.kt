package com.example.featurec

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.featurec.databinding.FragmentFeaturecBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class FeatureCFragment : Fragment() {
    private var _binding: FragmentFeaturecBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FeatureCViewModel by viewModel {
        parametersOf(object : FeatureCNavigation {
            override fun navigateFromCToA() {
                (activity as? FeatureCNavigation)?.navigateFromCToA()
            }

            override fun navigateFromCToB() {
                (activity as? FeatureCNavigation)?.navigateFromCToB()
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFeaturecBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFeaturecBinding.bind(view)

        binding.buttonNavigateToFeaturea.setOnClickListener {
            viewModel.onFeatureANavigationRequested()
        }

        binding.buttonNavigateToFeaturec.setOnClickListener {
            viewModel.onFeatureBNavigationRequested()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
