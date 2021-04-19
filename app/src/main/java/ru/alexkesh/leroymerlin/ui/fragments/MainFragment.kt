package ru.alexkesh.leroymerlin.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.alexkesh.leroymerlin.R
import ru.alexkesh.leroymerlin.data.remote.ApiServiceImpl
import ru.alexkesh.leroymerlin.data.repository.RepositoryImpl
import ru.alexkesh.leroymerlin.databinding.FragmentMainBinding
import ru.alexkesh.leroymerlin.ui.adapters.GroupAdapter
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

        binding.rvGroups.adapter = GroupAdapter().also { it.submitList(viewModel.getGroups()) }
        binding.rvGroups.setHasFixedSize(true)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}