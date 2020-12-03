package com.sunggil.blesample.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sunggil.basemvvm.vm.BaseAndroidViewModel

abstract class BaseFragment<T : ViewDataBinding, VM : ViewModel> : Fragment() {
    private lateinit var viewDataBinding : T
    private lateinit var viewModel : VM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayout(), container, false)
        val view = viewDataBinding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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