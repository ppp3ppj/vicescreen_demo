package com.ppp.vicescreendemo.presentation

import android.app.Presentation
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Display

open class PresentationUtils(outerContext: Context?, display: Display?) :
    Presentation(outerContext, display) {

    private companion object {
        private const val TAG:String = "pppDebug"
    }

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "OnCreate");
    }

    override fun hide() {
        super.hide()
        Log.i(TAG, "Hide");
    }

    override fun show() {
        super.show()
        Log.i(TAG, "Show");
    }

    override fun dismiss() {
        super.dismiss()
        Log.i(TAG, "Dismiss");
    }
}