package com.clb.lx.adapter

import android.content.Intent
import com.clb.lx.R
import com.clb.lx.app.MyApp
import com.clb.lx.databinding.ItemHomeMenuBinding
import com.clb.lx.dtos.HomeMenuDto

class HomeMenuAdapter: DataBoundAdapter<HomeMenuDto, ItemHomeMenuBinding>() {
    override val layoutId: Int
        get() = R.layout.item_home_menu

    override fun initView(binding: ItemHomeMenuBinding, item: HomeMenuDto, position: Int) {
        binding.dto = item

        binding.root.setOnClickListener {
            it.context.startActivity(item.nextIntent)

        }
    }
}