package com.ppp.vicescreendemo.present

import android.app.Presentation
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.view.Display
import com.ppp.vicescreendemo.R
import com.ppp.vicescreendemo.presentation.PresentationUtils

class TextDisplay(outerContext: Context?, display: Display?) :
    PresentationUtils(outerContext, display) {

    var mContext: Context? = null;

    init {
        mContext = outerContext
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vice_text_layout)
    }

    override fun show() {
        super.show()
    }

    override fun dismiss() {
        super.dismiss()
    }

    override fun hide() {
        super.hide()
    }

}