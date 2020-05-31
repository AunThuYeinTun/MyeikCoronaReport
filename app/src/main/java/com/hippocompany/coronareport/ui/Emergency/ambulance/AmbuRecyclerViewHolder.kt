package com.android.coronaapiwithkotlin.ui.Emergency.ambulance

import android.util.Log
import android.view.View
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hippocompany.coronareport.R
import kotlinx.android.synthetic.main.custom_list.view.*

class AmbuRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val AmbunameTxt=itemView.findViewById<TextView>(R.id.ambu_name)
    val AmbulocationTxt=itemView.findViewById<TextView>(R.id.ambu_location)


}
