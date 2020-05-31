package com.hippocompany.coronareport.ui.Emergency

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.android.coronaapiwithkotlin.ui.Emergency.Goverment.GovFragment
import com.android.coronaapiwithkotlin.ui.Emergency.Orgnization.OrgnizationFragment
import com.android.coronaapiwithkotlin.ui.Emergency.ambulance.AmbuGovFragment
import com.android.coronaapiwithkotlin.ui.Emergency.health.HealthGovFragment
import com.hippocompany.coronareport.R

class EmergencyFragment : Fragment() {

    private lateinit var govCardView: CardView
    private lateinit var ambulanceCardView: CardView
    private lateinit var healthCardView: CardView
    private lateinit var communityCardView: CardView
    private lateinit var aboutcard: CardView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_emergency, container, false)
        govCardView = root.findViewById(R.id.govCard)
        ambulanceCardView = root.findViewById(R.id.ambulanceCard)
        healthCardView = root.findViewById(R.id.healthCard)
        communityCardView = root.findViewById(R.id.communityCard)
        aboutcard = root.findViewById(R.id.about_card)
        govCardView.setOnClickListener {
            val fragment = GovFragment()
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.emergencyContainer, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        ambulanceCardView.setOnClickListener {
            val fragment = AmbuGovFragment()
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.emergencyContainer, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        healthCardView.setOnClickListener {
            val fragment = HealthGovFragment()
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.emergencyContainer, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        communityCardView.setOnClickListener {
            val fragment = OrgnizationFragment()
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.emergencyContainer, fragment)
            transaction.addToBackStack(null)
            transaction.commit()

        }
        aboutcard.setOnClickListener(View.OnClickListener {
            startActivity(Intent(view?.context, AboutActivity::class.java))
        })
        return root
    }
}