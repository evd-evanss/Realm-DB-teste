package com.sayhitoiot.realmdatabase

import android.graphics.Color
import android.view.View
import android.widget.ImageView

class ItemAppBarNav(val view: View, val pos: Int ) {

    fun setPressed(){
        when(pos){
            0 -> {
                view.findViewById<ImageView>(R.id.item_home)
                view.setBackgroundColor(Color.RED)
            }
        }
    }

}