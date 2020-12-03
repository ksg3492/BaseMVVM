package com.sunggil.basemvvm.vm

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    abstract fun onDestroy()
}