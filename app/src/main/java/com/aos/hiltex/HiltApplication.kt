package com.aos.hiltex

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication: Application() {
    companion object {
        const val TAG = "debugLog"
    }
}