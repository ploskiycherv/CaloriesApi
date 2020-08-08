package com.example.caloriesapi.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.caloriesapi.R
import com.example.caloriesapi.presentation.list.CaloriesListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction: FragmentTransaction =
            supportFragmentManager.beginTransaction().addToBackStack(null)
        fragmentTransaction.replace(
            R.id.mainContainer,
            CaloriesListFragment()
        )
        fragmentTransaction.commit()

    }
}