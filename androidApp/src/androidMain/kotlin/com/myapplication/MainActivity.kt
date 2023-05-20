package com.myapplication

import HomeViewModel
import MainView
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val homeViewModel: HomeViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainView(homeViewModel)
        }
    }
}