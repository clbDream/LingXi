package com.clb.lx.binds

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(value = ["url"])
fun bindImage(iv: ImageView, url: String?) {
    if (url != null) {
        Glide.with(iv.context).load(url).into(iv)
    }
}

@BindingAdapter(value = ["imgPath"])
fun bindImage(iv: ImageView, imgPath: Int) {
    if (imgPath != null) {
        Glide.with(iv.context).load(imgPath).into(iv)
    }
}