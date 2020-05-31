package com.android.coronaapiwithkotlin.ui.Emergency.health

import android.util.Log
import android.view.View
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hippocompany.coronareport.R
import kotlinx.android.synthetic.main.custom_list.view.*

class HealthRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val HealthnameTxt=itemView.findViewById<TextView>(R.id.health_name)
    val HealthlocationTxt=itemView.findViewById<TextView>(R.id.health_location)


}
