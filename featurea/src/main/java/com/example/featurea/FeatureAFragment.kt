package com.example.featurea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.featurea.databinding.FragmentFeatureaBinding
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class FeatureAFragment : Fragment(), FeatureAContract.View {
    private var _binding: FragmentFeatureaBinding? = null
    private val binding get() = _binding!!

    private val presenter: FeatureAContract.Presenter by inject {
        parametersOf(this, object : FeatureANavigation {
            override fun navigateFromAToB() {
                (activity as? FeatureANavigation)?.navigateFromAToB()
            }

            override fun navigateFromAToC() {
                (activity as? FeatureANavigation)?.navigateFromAToC()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeatureaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFeatureaBinding.bind(view)

        presenter.onViewCreated()

        binding.buttonNavigateToFeatureb.setOnClickListener {
            presenter.onFeatureBNavigationRequested()
        }

        binding.buttonNavigateToFeaturec.setOnClickListener {
            presenter.onFeatureCNavigationRequested()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}


