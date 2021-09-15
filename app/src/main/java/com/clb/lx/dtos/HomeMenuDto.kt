package com.clb.lx.dtos

import android.content.Intent

data class HomeMenuDto(
    val menuName: String,
    val menuIcon: Int,
    val bgColor: Int,
    val nextIntent: Intent
)
