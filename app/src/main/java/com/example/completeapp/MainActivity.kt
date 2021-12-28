package com.example.completeapp

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)

        qustions.setOnClickListener{
           var new_color =  resources.getColor(R.color.background__btn_after)
            qustions.setBackgroundColor(new_color)
            var i = Intent(this,SecondActivity::class.java)
            startActivity(i)
        }

        rate.setOnClickListener{
          var new_color =  resources.getColor(R.color.background__btn_after)
            rate.setBackgroundColor(new_color)
            try{
                var uri = Uri.parse("market://details?id $packageName")
                var goToMarket = Intent(Intent.ACTION_VIEW)
                goToMarket.data = uri
                startActivity(goToMarket)

            }catch (e : ActivityNotFoundException)
            {
                var uri = Uri.parse("http://play.google.com/store/apps/details?id $packageName")
                var goToMarket = Intent(Intent.ACTION_VIEW)
                goToMarket.data = uri
                startActivity(goToMarket)

            }
        }
    }


}