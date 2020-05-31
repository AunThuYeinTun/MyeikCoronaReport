package com.android.coronaapiwithkotlin.ui.Emergency.health

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hippocompany.coronareport.R


class HealthRecyclerViewAdapter: RecyclerView.Adapter<HealthRecyclerViewHolder>() {

    val HealthnameList= listOf<String>("ဒေါက်တာထွန်းမင်း","ဒေါက်တာလွင်လွင်မွန်","ဒေါက်တာသန္တာမျိုး၀င်း","ဒေါက်တာပြုံးချို","ဒေါက်တာရဲမင်းဦး","ဒေါက်တာလင်းထိုက်")
    val HealthlocationList= listOf<String>("တိုင်းကျန်းမာရေး","မြိတ်မြို့နယ်","မြိတ်မြို့နယ်","ပုလောမြို့နယ်","ကျွန်းစုမြို့နယ်","တနင်္သာရီမြို့နယ်")
    val Healthphlist= listOf<String>("095301579","09960470887","095192432","09450994746","09425722191","09425269446")
    //private lateinit var context:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthRecyclerViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.helath_custom_list,parent,false)
        return HealthRecyclerViewHolder(view)
        }
    override fun getItemCount(): Int {
        return HealthnameList.size
    }

    override fun onBindViewHolder(holder: HealthRecyclerViewHolder, position: Int) {
        holder.HealthnameTxt.text=HealthnameList[position]
        holder.HealthlocationTxt.text=HealthlocationList[position]

       holder.itemView.setOnClickListener{ v: View -> Unit
           val context=holder.HealthnameTxt.context
          Log.i("Log Index = ",Healthphlist[position])
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+Healthphlist.get(position)))
           context.startActivity(intent)
        }
    }

}