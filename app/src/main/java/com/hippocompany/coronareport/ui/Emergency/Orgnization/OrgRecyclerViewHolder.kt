package com.android.coronaapiwithkotlin.ui.Emergency.Orgnization

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hippocompany.coronareport.R


class OrgRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val OrgnameTxt=itemView.findViewById<TextView>(R.id.org_name)
    val OrglocationTxt=itemView.findViewById<TextView>(R.id.org_location)


}