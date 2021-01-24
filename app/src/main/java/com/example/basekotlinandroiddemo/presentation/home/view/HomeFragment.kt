package com.example.basekotlinandroiddemo.presentation.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.observe
import com.example.basekotlinandroiddemo.presentation.home.model.HomeResponse
import com.example.basekotlinandroiddemo.databinding.FragmentHomeBinding
import com.example.basekotlinandroiddemo.presentation.home.viewModel.HomeViewModel
import com.example.corelibrary.base.BaseFragmentBinding
import com.example.corelibrary.extensions.toGone
import com.example.corelibrary.extensions.toVisible
import com.example.corelibrary.extensions.toast
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragmentBinding<FragmentHomeBinding>(), HomeItem.HomeItemListener {

    @Inject
    lateinit var homeViewModel: HomeViewModel
    private val adapter = GroupAdapter<GroupieViewHolder>()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate

    override fun initView(binding: FragmentHomeBinding): Unit = with(binding) {
        recyclerView.adapter = adapter
        homeViewModel.viewState().observe(viewLifecycleOwner) { state ->
            when (state) {
                is HomeViewModel.ViewState.Loading -> progressBar.toVisible()
                is HomeViewModel.ViewState.Success -> {
                    progressBar.toGone()
                    state.response.map {
                        adapter.add(HomeItem(it, this@HomeFragment))
                    }
                }
                is HomeViewModel.ViewState.Error -> {
                    progressBar.toGone()
                    toast("網路異常")
                }
            }
        }
        getData()
    }

    private fun getData() = homeViewModel.getHomeResponse()

    override fun onClickListener(item: HomeResponse.Item) = toast(item.title)
}