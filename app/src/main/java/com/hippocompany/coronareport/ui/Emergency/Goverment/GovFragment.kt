package com.android.coronaapiwithkotlin.ui.Emergency.Goverment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hippocompany.coronareport.R

class GovFragment : Fragment() {
    private  lateinit var list: RecyclerView
    private lateinit var toolbar:Toolbar

    //private  lateinit var myListAdapter:MyListAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var appCompatActivity=activity as AppCompatActivity
        val root = inflater.inflate(R.layout.gov_fragment_layout, container, false)
        val rootorg = inflater.inflate(R.layout.org_fragment_layout, container, false)
        val roothel = inflater.inflate(R.layout.health_fragment_layout, container, false)
        val rootamb = inflater.inflate(R.layout.ambulance_fragment_layout, container, false)
       toolbar=root.findViewById(R.id.toolbar)
  /*
        appCompatActivity.supportFragmentManager
        appCompatActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        appCompatActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)*/
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        toolbar.setNavigationOnClickListener{
            val govconstraintLayout:ConstraintLayout=root.findViewById(R.id.gov_container)
            val healthconstraintLayout:ConstraintLayout=roothel.findViewById(R.id.health_container)
            val ambuconstraintLayout:ConstraintLayout=rootamb.findViewById(R.id.ambu_container)
            val orgconstraintLayout:ConstraintLayout=rootorg.findViewById(R.id.org_container)

            govconstraintLayout.visibility=View.INVISIBLE
            healthconstraintLayout.visibility=View.INVISIBLE
            ambuconstraintLayout.visibility=View.INVISIBLE
            orgconstraintLayout.visibility=View.INVISIBLE
            val transaction=childFragmentManager.beginTransaction()
            transaction.addToBackStack(null)

        }


        list=root.findViewById(R.id.list)
        val recyclerViewAdapter: RecyclerViewAdapter = RecyclerViewAdapter()
        list.hasFixedSize()
        recyclerViewAdapter.notifyDataSetChanged()
        list.adapter= RecyclerViewAdapter()
        list.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)


        return root
    }


}