package com.sunggil.basemvvm.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel

abstract class BaseAndroidViewModel(application: Application) : AndroidViewModel(application) {
    abstract fun onDestroy()
}