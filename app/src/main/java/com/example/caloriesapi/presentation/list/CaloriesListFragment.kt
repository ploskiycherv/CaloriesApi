package com.example.caloriesapi.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.caloriesapi.R
import com.example.caloriesapi.presentation.MainActivity
import com.example.caloriesapi.presentation.list.adapter.CaloriesListAdapter
import com.example.caloriesapi.presentation.list.adapter.CaloriesListDiffUtil
import kotlinx.android.synthetic.main.fragment_calories_list.*
import org.koin.android.ext.android.inject


class CaloriesListFragment : Fragment() {

    private val viewModel: CaloriesListModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_calories_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val caloriesListAdapter = CaloriesListAdapter(CaloriesListDiffUtil())
        caloriesListRecyclerView.layoutManager = LinearLayoutManager(activity)
        caloriesListRecyclerView.adapter = caloriesListAdapter

        with(viewModel) {
            caloriesItemLiveData().observe(viewLifecycleOwner, Observer { data ->
                caloriesListAdapter.submitList(data)
            })
            getCalories()
        }

    }
}