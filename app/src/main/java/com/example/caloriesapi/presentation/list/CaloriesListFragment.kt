package com.example.caloriesapi.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.caloriesapi.R
import com.example.caloriesapi.presentation.list.adapter.CaloriesListAdapter
import com.example.caloriesapi.presentation.list.adapter.CaloriesListDiffUtil
import kotlinx.android.synthetic.main.fragment_calories_list.*
import org.koin.android.ext.android.inject


class CaloriesListFragment : Fragment(R.layout.fragment_calories_list) {

    private val viewModel: CaloriesListModel by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val caloriesListAdapter = CaloriesListAdapter(CaloriesListDiffUtil())
        caloriesListRecyclerView.layoutManager = LinearLayoutManager(activity)
        caloriesListRecyclerView.adapter = caloriesListAdapter

        with(viewModel) {
            caloriesItemLiveData().observe(viewLifecycleOwner, Observer { data ->
                caloriesListAdapter.submitList(data)
            })

            errorLiveData().observe(viewLifecycleOwner, Observer {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            })

            getListCalories()
        }

        caloriesListSearchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    viewModel.changeFilter(p0 ?: "")
                    return true
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    //do nothing
                    return true
                }
            }
        )

        caloriesListSearchView.setOnCloseListener {
            viewModel.changeFilter("")
            true
        }
    }
}