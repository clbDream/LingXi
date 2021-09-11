package com.clb.lx.ui.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    abstract val layoutId: Int
    lateinit var binding: T
    private lateinit var mContext: Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel(view, savedInstanceState)
        initView(view, savedInstanceState)
        initData(view, savedInstanceState)
        initClick(view, savedInstanceState)
        loadData(view)
    }

    /**
     * 初始化ViewModel
     */
    open fun initViewModel(view: View, savedInstanceState: Bundle?) {

    }

    private fun loadData(view: View) {

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    /**
     * 初始化页面相关配置
     */
    abstract fun initView(view: View, savedInstanceState: Bundle?)

    /**
     * 初始化数据
     */
    abstract fun initData(view: View, savedInstanceState: Bundle?)

    /**
     * 点击事件相关
     */
    abstract fun initClick(view: View, savedInstanceState: Bundle?)

    /**
     * 保证同一按钮在1秒内只响应一次点击事件
     */
    abstract class OnSingleClickListener : View.OnClickListener {
        private var lastClickTime: Long = 0
        abstract fun onSingleClick(view: View?)
        override fun onClick(v: View) {
            val curClickTime = System.currentTimeMillis()
            if (curClickTime - lastClickTime >= MIN_CLICK_DELAY_TIME) {
                lastClickTime = curClickTime
                onSingleClick(v)
            }
        }

        companion object {
            //两次点击按钮的最小间隔，目前为1000
            private const val MIN_CLICK_DELAY_TIME = 1000
        }
    }

    /**
     * 同一按钮在短时间内可重复响应点击事件
     */
    abstract class OnMultiClickListener : View.OnClickListener {
        abstract fun onMultiClick(view: View?)
        override fun onClick(v: View) {
            onMultiClick(v)
        }
    }


    // startActivity
    protected open fun startActivity(cls: Class<*>?, bundle: Bundle?) {
        val intent = Intent(mContext, cls)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    // startActivity
    protected open fun startActivity(cls: Class<*>?) {
        startActivity(cls, null)
    }

    // startActivityForResult
    protected open fun startActivityForResult(
        cls: Class<*>?,
        bundle: Bundle?,
        requestCode: Int
    ) {
        val intent = Intent(mContext, cls)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivityForResult(intent, requestCode)
    }

    // startActivityForResult
    protected open fun startActivityForResult(
        cls: Class<*>?,
        requestCode: Int
    ) {
        startActivityForResult(cls, null, requestCode)
    }
}