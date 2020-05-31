package com.android.coronaapiwithkotlin.ui.Emergency.ambulance

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hippocompany.coronareport.R


class AmbuRecyclerViewAdapter: RecyclerView.Adapter<AmbuRecyclerViewHolder>() {

    val AmbunameList= listOf<String>("ကိုကောင်ကြီး","ကိုကောက်ရိုက်","ကိုကိုင်ဇာ","ကိုတူးတူး","ကိုအောင်မြတ်သူ","မေတ္တာရှင်","သုခရွှေရည်")
    val AmbulocationList= listOf<String>("မြိတ်","မြိတ်","မြိတ်","ကျောက်ဖျာ","တုံးဗျော","ပုလော","တနင်္သာရီ")
    val Ambuphlist= listOf<String>("0941005973","09785551547","095504073","09425272627","09454393922","09692453338","09260188018")
    //private lateinit var context:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmbuRecyclerViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.ambu_custom_list,parent,false)
        return AmbuRecyclerViewHolder(view)
        }
    override fun getItemCount(): Int {
        return AmbunameList.size
    }

    override fun onBindViewHolder(holder: AmbuRecyclerViewHolder, position: Int) {
        holder.AmbunameTxt.text=AmbunameList[position]
        holder.AmbulocationTxt.text=AmbulocationList[position]

       holder.itemView.setOnClickListener{ v: View -> Unit
           val context=holder.AmbunameTxt.context
          Log.i("Log Index = ",AmbunameList[position])
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+Ambuphlist.get(position)))
           context.startActivity(intent)
        }
    }

}