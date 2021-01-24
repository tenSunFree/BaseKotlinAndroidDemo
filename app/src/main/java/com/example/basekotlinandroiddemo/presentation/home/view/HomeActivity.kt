package com.example.basekotlinandroiddemo.presentation.home.view

import android.view.LayoutInflater
import com.example.basekotlinandroiddemo.databinding.ActivityHomeBinding
import com.example.corelibrary.base.BaseActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivityBinding<ActivityHomeBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityHomeBinding
        get() = ActivityHomeBinding::inflate

    override fun setupView(binding: ActivityHomeBinding) {}
}