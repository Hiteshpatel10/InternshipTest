package com.geekaid.internshiptest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.geekaid.internshiptest.TheProjectAdapter
import com.geekaid.internshiptest.database.TheProjectDatabase
import com.geekaid.internshiptest.databinding.FragmentHomeBinding
import com.geekaid.internshiptest.model.TheProject

class HomeFragment : Fragment(), TheProjectAdapter.ITheProjectListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: TheProjectAdapter
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val application = requireNotNull(this.activity).application
        val dataBase = TheProjectDatabase.getDatabase(application).theProjectDao()
        val homeViewModelFactory = HomeViewModelFactory(dataBase)
        homeViewModel =
            ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel::class.java)


        //Adapter
        adapter = TheProjectAdapter(this)
        binding.homeRecyclerView.adapter = adapter



        homeViewModel.allData.observe(viewLifecycleOwner) {
            it?.let {
                adapter.allData = it
            }
        }

        binding.addButton.setOnClickListener {
            val data = TheProject(
                code = System.currentTimeMillis(),
                anything = 1
            )
            homeViewModel.insert(data)
        }

        return root
    }

    override fun onItemClicked(theProject: TheProject) {
        homeViewModel.delete(theProject)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}