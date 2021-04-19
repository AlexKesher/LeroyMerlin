package ru.alexkesh.leroymerlin.ui.fragments

import android.animation.ArgbEvaluator
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.alexkesh.leroymerlin.R
import ru.alexkesh.leroymerlin.data.remote.ApiServiceImpl
import ru.alexkesh.leroymerlin.data.repository.RepositoryImpl
import ru.alexkesh.leroymerlin.databinding.FragmentMainBinding
import ru.alexkesh.leroymerlin.ui.adapters.GroupAdapter
import ru.alexkesh.leroymerlin.ui.adapters.ProductAdapter
import ru.alexkesh.leroymerlin.viewmodels.MainViewModel
import ru.alexkesh.leroymerlin.viewmodels.MainViewModelFactory

class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(RepositoryImpl(ApiServiceImpl()))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.window?.statusBarColor = requireContext().getColor(R.color.brand_green)
        setMotionLayoutListener()

        binding.rvGroups.adapter = GroupAdapter().also { it.submitList(viewModel.getGroups()) }
        binding.rvGroups.setHasFixedSize(true)

        displayRecentlyWatchedItems()

    }

    private fun displayRecentlyWatchedItems() {
        val recentProductsList = viewModel.getRecentlyWatchedProducts()
        if (recentProductsList.isNullOrEmpty()) {
            binding.rvRecentProducts.visibility = View.GONE
            binding.tvRecentProducts.visibility = View.GONE
        } else {
            binding.rvRecentProducts.visibility = View.VISIBLE
            binding.tvRecentProducts.visibility = View.VISIBLE

            binding.rvRecentProducts.apply {
                adapter = ProductAdapter().also { it.submitList(recentProductsList) }
                setHasFixedSize(true)
            }
        }
    }

    private fun setMotionLayoutListener() {
        binding.mainMotionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, progress: Float) {
                setStatusBarColor(progress)
            }

            override fun onTransitionCompleted(p0: MotionLayout, p1: Int) {
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }
        })
    }

    private fun setStatusBarColor(progress: Float) {
        val color = (binding.toolbar.background as? ColorDrawable)?.color
        color?.let { activity?.window?.statusBarColor = it }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}