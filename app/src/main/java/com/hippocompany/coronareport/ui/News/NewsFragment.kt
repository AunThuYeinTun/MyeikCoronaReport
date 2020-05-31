package com.hippocompany.coronareport.ui.News

import DataModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.hippocompany.coronareport.R
import com.hippocompany.coronareport.RecyclerViewAdapter
import com.hippocompany.myeikcoronareportserver.DownloadData
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment() {


    private var mRecyclerView: RecyclerView? = null
    var listofNews: ArrayList<DataModel> = ArrayList()
    private var mAdapter: RecyclerView.Adapter<*>? = null
    var Database_Path = "All_News_Uploads_Database/UpdateNews"
    lateinit var databaseReference: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_news, container, false)
        mRecyclerView = root.findViewById(R.id.recyclerView)

        var layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
        layoutManager.stackFromEnd=true
        mRecyclerView?.layoutManager = layoutManager
        mRecyclerView?.setHasFixedSize(true);
        databaseReference = FirebaseDatabase.getInstance().reference.child(
            Database_Path
        )
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                Log.v("$databaseError", "Show Error Message")
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot!!.exists()) {
                    progress_circular.visibility=View.GONE
                    listofNews.clear()
                    for (h in dataSnapshot.children) {
                        val downloadData = h.getValue(DownloadData::class.java)
                        if (downloadData != null) {
                            listofNews.add(
                                DataModel(
                                    downloadData.caption,
                                    downloadData.date,
                                    downloadData.body,
                                    downloadData.newsImageUrl
                                )
                            )
                        }
                    }
                    val adapter = RecyclerViewAdapter(listofNews)
                    mRecyclerView?.adapter = adapter
                }
            }
        })
        return root
    }
}
