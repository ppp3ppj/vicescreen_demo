package com.ppp.vicescreendemo.utils

import android.content.Context
import android.graphics.Point
import android.graphics.Rect
import android.hardware.display.DisplayManager
import android.util.Log
import android.view.Display

class ScreenManager private constructor() {
    private var TAG:String = "debugppp";

    var displays: Array<Display>? = null
        private set
    var isMinScreen = false


    public companion object {
        var manager: ScreenManager? = null

        @Synchronized
        fun getInstance(): ScreenManager? {
            if (manager == null) {
                synchronized(ScreenManager::class.java) {
                    if (manager == null) {
                        manager = ScreenManager()
                    }
                }
            }
            return manager!!
        }
    }

    fun init(context: Context) {
        var mDisplayManager: DisplayManager = context.getSystemService(Context.DISPLAY_SERVICE) as DisplayManager;
        displays = mDisplayManager.displays
        Log.d(TAG, "init: ------------------------>" + displays?.size)

        if(displays?.size!! > 1) {
            var outSize0 = Rect();
            displays?.get(0)?.getRectSize(outSize0);
            var outSize1 = Rect();
            displays?.get(1)?.getRectSize(outSize1);
            if(outSize0.right - outSize1.right > 100) {
                isMinScreen = true;
            }
        }
    }


    val presentationDisplays: Display?
        get() {
            for (i in displays!!.indices) {
                Log.e(TAG, "屏幕" + displays!![i])
                if (displays!![i].flags and Display.FLAG_SECURE != 0 && displays!![i].flags and Display.FLAG_SUPPORTS_PROTECTED_BUFFERS != 0 && displays!![i].flags and Display.FLAG_PRESENTATION != 0) {
                    Log.e(TAG, "第一个真实存在的副屏屏幕" + displays!![i])
                    return displays!![i]
                }
            }
            return null
        }



}
