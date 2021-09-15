package com.clb.lx.ui.home

import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.clb.lx.R
import com.clb.lx.app.MyApp
import com.clb.lx.dtos.HomeMenuDto
import com.clb.lx.ui.home.memo.MemoActivity

class HomeViewModel : ViewModel() {

    private val menuList = MutableLiveData<List<HomeMenuDto>>().apply {
        value = listOf(
            HomeMenuDto(
                "便签",
                R.mipmap.home_menu_bianqian,
                ContextCompat.getColor(MyApp.getAppContext(), R.color.blue),
                Intent(MyApp.getAppContext(),MemoActivity::class.java)
            ),
            HomeMenuDto(
                "密码箱",
                R.mipmap.home_menu_pwd_box,
                ContextCompat.getColor(MyApp.getAppContext(), R.color.green),
                Intent(MyApp.getAppContext(),MemoActivity::class.java)
            ),
        )
    }

    val homeMenuList = menuList
}