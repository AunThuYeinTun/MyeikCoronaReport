package com.hippocompany.coronareport

import DataModel
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton

class RecyclerViewAdapter(private val dataModel: ArrayList<DataModel>) :

    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    lateinit var context: Context

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(viewGroup?.context)
            .inflate(R.layout.custom_new_card_item, viewGroup, false)
        return MyViewHolder(view);
    }

    override fun getItemCount(): Int {
        return dataModel.size
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {

        viewHolder.caption?.text = dataModel[position].caption
        viewHolder.date?.text = dataModel[position].postDate
        context = viewHolder.itemView.context
        Glide.with(context).load(dataModel[position].imageCardView)
            .into(viewHolder.cardImage)
        viewHolder.seeMorebutton.setOnClickListener { v ->
            val intent: Intent = Intent(v?.context, DetailActivity::class.java)
            intent.putExtra("Caption", dataModel[position].caption)
            intent.putExtra("Body", dataModel[position].body)
            intent.putExtra("Date", dataModel[position].postDate)
            intent.putExtra("Image", dataModel[position].imageCardView)
            //intent.putExtra("Caption", dataModel[position].caption)
            v?.context?.startActivity(intent)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val caption: TextView
        val date: TextView
        val cardImage: ImageView
        val seeMorebutton: MaterialButton

        init {
            caption = itemView.findViewById<TextView>(R.id.textView_cardCaption)
            date = itemView.findViewById<TextView>(R.id.textView_card_source_of_news)
            cardImage = itemView.findViewById<ImageView>(R.id.imageView_cardImage)
            seeMorebutton = itemView.findViewById(R.id.btn_SeeMore)
        }

    }
}