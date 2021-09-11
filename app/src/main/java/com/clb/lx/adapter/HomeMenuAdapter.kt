package com.clb.lx.adapter

import com.clb.lx.R
import com.clb.lx.databinding.ItemHomeMenuBinding
import com.clb.lx.dtos.HomeMenuDto

class HomeMenuAdapter: DataBoundAdapter<HomeMenuDto, ItemHomeMenuBinding>() {
    override val layoutId: Int
        get() = R.layout.item_home_menu

    override fun initView(binding: ItemHomeMenuBinding, item: HomeMenuDto, position: Int) {
        binding.dto = item
    }
}