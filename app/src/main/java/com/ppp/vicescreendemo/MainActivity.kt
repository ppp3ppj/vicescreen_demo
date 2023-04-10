package com.ppp.vicescreendemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context;
import android.util.Log
import android.view.Display
import android.widget.Button
import android.widget.TextView
import com.ppp.vicescreendemo.present.TextDisplay
import com.ppp.vicescreendemo.utils.ScreenManager

class MainActivity : AppCompatActivity() {

    public var screenManager: ScreenManager? = null;
    public var mContext: Context? = null;
    public var displays: Array<Display>? = null;

    var displayM: Display? = null;

    var textDisplay: TextDisplay? = null;


    private lateinit var textViewInfo : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mContext = this
        initData();

        if(displayM != null) {
            //textDisplay!!.show();
        }

        // get reference to button and set on click listener
        val btn_show= findViewById(R.id.button_show_text) as Button
        btn_show.setOnClickListener {
            if(displayM != null) {
                textDisplay = TextDisplay(mContext, displayM);
                textDisplay!!.show();
            }
        }
    }

    private fun initData() {
        screenManager = ScreenManager.getInstance()
        screenManager?.init(mContext!!)

        displays = screenManager?.displays
        displayM = screenManager?.presentationDisplays;
        Log.e("debugppp", displayM.toString())

        setTextView(displayM.toString());
        Log.d("debugppp", displays?.size.toString())

        for(display in displays!!) {
            Log.e("debugppp", "D : " + displays.toString())
        }

        if(displayM != null) {
            textDisplay = TextDisplay(mContext, displayM);
        }
    }

    private fun setTextView(data: String) {
      textViewInfo = findViewById<TextView>(R.id.MainDisplay)
        textViewInfo.text = data
    }
}