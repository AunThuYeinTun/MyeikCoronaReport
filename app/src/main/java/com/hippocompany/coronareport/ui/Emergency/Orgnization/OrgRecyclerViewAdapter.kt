package com.android.coronaapiwithkotlin.ui.Emergency.Orgnization

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hippocompany.coronareport.R


class OrgRecyclerViewAdapter: RecyclerView.Adapter<OrgRecyclerViewHolder>() {

    val OrgnameList= listOf<String>("ဦးပိုအင်","ဦးကောက်ရိုက်","ဦးမိုးသူအောင်","ဦးစဧရာ၀င်း","ဦးထွန်းမင်း","ဦးမင်းလွင်ဦး","ဦးထွန်းတောက်","ဦးထွန်းထွန်းဦး")
    val OrglocationList= listOf<String>("ဥက္ကဌ","နယက","အတွင်းရေးမှူး","လူထုဆက်ဆံရေး","နယက(ဘဏ္ဍာ)","သတင်းနှင့်ပြန်ကြားရေး","သတင်းနှင့်ပြန်ကြားရေး","စစ်ဆေးရေးဂိတ်များတာ၀န်ခံ")
    val Orgphlist= listOf<String>("09253625532","09785551547","09422225836","09422220002","09428763335","09450993538","095641302","095640941")
    //private lateinit var context:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrgRecyclerViewHolder {

        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.org_custom_list,parent,false)
        return OrgRecyclerViewHolder(view)
    }
    override fun getItemCount(): Int {
        return OrgnameList.size
    }

    override fun onBindViewHolder(holder: OrgRecyclerViewHolder, position: Int) {
        holder.OrgnameTxt.text=OrgnameList[position]
        holder.OrglocationTxt.text=OrglocationList[position]

        holder.itemView.setOnClickListener{ v: View -> Unit
            val context=holder.OrglocationTxt.context
            Log.i("Log Index = ",OrgnameList[position])
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+Orgphlist.get(position)))
            context.startActivity(intent)
        }
    }

}