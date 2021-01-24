package com.example.basekotlinandroiddemo.presentation.home.view

import android.annotation.SuppressLint
import android.view.View
import com.example.basekotlinandroiddemo.R
import com.example.basekotlinandroiddemo.databinding.ItemHomeBinding
import com.example.basekotlinandroiddemo.presentation.home.model.HomeResponse
import com.xwray.groupie.viewbinding.BindableItem

class HomeItem(private val item: HomeResponse.Item, private val listener: HomeItemListener) :
    BindableItem<ItemHomeBinding>() {

    interface HomeItemListener {
        fun onClickListener(item: HomeResponse.Item)
    }

    override fun getLayout(): Int = R.layout.item_home

    override fun initializeViewBinding(view: View): ItemHomeBinding = ItemHomeBinding.bind(view)

    @SuppressLint("SetTextI18n")
    override fun bind(viewBinding: ItemHomeBinding, position: Int) = with(viewBinding) {
        textViewTitle.text = "Title﹕${item.title}"
        textViewBody.text = "Body﹕${item.body}"
        this.root.setOnClickListener { listener.onClickListener(item) }
    }
}