package com.clb.lx.ui.home

import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.clb.lx.R
import com.clb.lx.app.MyApp
import com.clb.lx.dtos.HomeMenuDto

class HomeViewModel : ViewModel() {

    private val menuList = MutableLiveData<List<HomeMenuDto>>().apply {
        value = listOf(
            HomeMenuDto(
                "便签",
                R.mipmap.home_menu_bianqian,
                ContextCompat.getColor(MyApp.getAppContext(), R.color.blue)
            ),
            HomeMenuDto(
                "密码箱",
                R.mipmap.home_menu_pwd_box,
                ContextCompat.getColor(MyApp.getAppContext(), R.color.green)
            ),
        )
    }

    val homeMenuList = menuList
}