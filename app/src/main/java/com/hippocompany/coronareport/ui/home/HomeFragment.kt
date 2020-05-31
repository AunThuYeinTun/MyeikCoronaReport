package com.hippocompany.coronareport.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.hippocompany.coronareport.R
import org.json.JSONException
import org.json.JSONObject
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {
    lateinit var tvTotalConfirmed: TextView
    lateinit var tvTotalDeaths: TextView
    lateinit var tvTotalRecovered: TextView
    lateinit var tvTodayTotalConfirmed: TextView
    lateinit var tvTodayTotalDeaths: TextView
    lateinit var date: TextView
    lateinit var progressBar: ProgressBar
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        tvTotalConfirmed = root.findViewById(R.id.TotalconfirmedTV)
        tvTotalDeaths = root.findViewById(R.id.tvTotalDeaths)
        tvTotalRecovered = root.findViewById(R.id.tvTotalRecovered)
        tvTodayTotalConfirmed = root.findViewById(R.id.tvTodayTotalConfirmed)
        tvTodayTotalDeaths = root.findViewById(R.id.tvTodayTotalDeaths)
        progressBar = root.findViewById(R.id.progress_circular_home)
        date = root.findViewById(R.id.tvdate)

        getdata()
        return root
    }

    private fun getdata() {
        val queue = Volley.newRequestQueue(activity!!)
        val url = "https://covid19.joymogok.com//mm.json"
        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener { response ->
                progressBar.visibility = View.GONE
                try {
                    val jsonObject = JSONObject(response.toString())
                    date.text=(jsonObject.getString("dt"))
                    tvTotalConfirmed.text = (jsonObject.getString("confirm"))
                    tvTodayTotalConfirmed.text = (jsonObject.getString("newconfirm"))
                    tvTotalDeaths.text = (jsonObject.getString("deaths"))
                    tvTodayTotalDeaths.text = (jsonObject.getString("newdeaths"))
                    tvTotalRecovered.text = (jsonObject.getString("recovered"))
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }, Response.ErrorListener { error ->
                progressBar.visibility = View.GONE
                Log.d("Error Response", error.toString())
            })
        queue.add(stringRequest)
    }

}

