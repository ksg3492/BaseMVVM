package com.sunggil.basemvvm.util

import android.content.Context
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission

class Util {
    companion object {
        fun checkPermission(c : Context, listener : PermissionListener, vararg permissions : String) {
            TedPermission.with(c)
                .setPermissionListener(listener)
                .setPermissions(*permissions)
                .check()
        }
    }
}