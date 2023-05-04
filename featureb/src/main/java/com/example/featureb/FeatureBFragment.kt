package com.example.featureb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.featureb.databinding.FragmentFeaturebBinding
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class FeatureBFragment : Fragment(), FeatureBContract.View {
    private var _binding: FragmentFeaturebBinding? = null
    private val binding get() = _binding!!

    private val presenter: FeatureBContract.Presenter by inject {
        parametersOf(this, object : FeatureBNavigation {
            override fun navigateFromBToA() {
                (activity as? FeatureBNavigation)?.navigateFromBToA()
            }

            override fun navigateFromBToC() {
                (activity as? FeatureBNavigation)?.navigateFromBToC()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeaturebBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.onViewCreated()

        binding.buttonBack.setOnClickListener {
            activity?.onBackPressed()
        }

        binding.buttonNavigateToFeaturea.setOnClickListener {
            presenter.onFeatureANavigationRequested()
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

