package com.hippocompany.coronareport.ui.Emergency

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textview.MaterialTextView
import com.hippocompany.coronareport.R

class AboutActivity : AppCompatActivity() {
    lateinit var tvAyt: MaterialTextView
    lateinit var tvthth: MaterialTextView
    lateinit var emaill: MaterialTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_activity)
        tvAyt = findViewById(R.id.tv_atyt)
        tvthth = findViewById(R.id.tv_thth)
        tvAyt.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/atyt.781998m")
                )
            )
        })
        tvthth.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/moderaty.man")
                )
            )
        })
        tvAyt.setPaintFlags(tvAyt.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)
        tvthth.setPaintFlags(tvthth.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)


    }
}