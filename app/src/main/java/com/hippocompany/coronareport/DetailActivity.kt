package com.hippocompany.coronareport

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.textview.MaterialTextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

            val caption:MaterialTextView=findViewById(R.id.tvDetailTitle)
            val date:MaterialTextView=findViewById(R.id.tvDetailSource)
            val body:MaterialTextView=findViewById(R.id.tvDetailBody)
            val image:ImageView=findViewById(R.id.DetailImage)

        if (getIntent().hasExtra("Caption")) {
          /*  Toast.makeText(
                this@DetailActivity,
                intent.getStringExtra("Caption").toString()+"====="+intent.getStringExtra("Body".toString()),
                Toast.LENGTH_SHORT
            ).show()*/

            caption.text=intent.getStringExtra("Caption").toString()
            date.text=intent.getStringExtra("Date").toString()
            body.text=intent.getStringExtra("Body").toString()
            Glide.with(this).load(intent.getStringExtra("Image"))
                .into(image)
        }
    }

}
