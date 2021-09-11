package com.clb.lx.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.clb.lx.R
import com.clb.lx.adapter.HomeMenuAdapter
import com.clb.lx.databinding.FragmentHomeBinding
import com.clb.lx.dtos.HomeMenuDto
import com.clb.lx.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private lateinit var homeMenuAdapter: HomeMenuAdapter
    private lateinit var viewModel: HomeViewModel

    override val layoutId: Int
        get() = R.layout.fragment_home


    override fun initViewModel(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    }
    override fun initView(view: View, savedInstanceState: Bundle?) {
        binding.menuList.also {
            it.layoutManager = GridLayoutManager(context,2)
            homeMenuAdapter = HomeMenuAdapter()
            it.adapter = homeMenuAdapter
        }
    }

    override fun initData(view: View, savedInstanceState: Bundle?) {
        viewModel.homeMenuList.observe(this){
            homeMenuAdapter.addAll(it,true)
        }
    }

    override fun initClick(view: View, savedInstanceState: Bundle?) {
        
    }

}