package com.android.coronaapiwithkotlin.ui.Emergency.Goverment

import android.util.Log
import android.view.View
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hippocompany.coronareport.R
import kotlinx.android.synthetic.main.custom_list.view.*

class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val nameTxt=itemView.findViewById<TextView>(R.id.name)
    val locationTxt=itemView.findViewById<TextView>(R.id.location)


}
