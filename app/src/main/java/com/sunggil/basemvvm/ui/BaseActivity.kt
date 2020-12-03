package com.sunggil.basemvvm.ui

import android.content.res.Configuration
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import com.sunggil.basemvvm.vm.BaseAndroidViewModel

abstract class BaseActivity<T : ViewDataBinding, VM : AndroidViewModel> : AppCompatActivity() {
    private lateinit var viewDataBinding : T
    private lateinit var viewModel : VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, getLayout())

        viewModel = ViewModelProvider(this).get(initViewModel()::class.java)

        bindingLiveData()
        initView()
    }

    fun getDataBinding() : T {
        return viewDataBinding
    }

    fun getViewModel() : VM {
        return viewModel
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onDestroy() {
        if (getViewModel() is BaseAndroidViewModel) {
            (getViewModel() as BaseAndroidViewModel).onDestroy()
        }

        super.onDestroy()
    }

    @NonNull abstract fun getLayout() : Int
    @NonNull abstract fun initViewModel() : VM
    abstract fun bindingLiveData()
    abstract fun initView()
}