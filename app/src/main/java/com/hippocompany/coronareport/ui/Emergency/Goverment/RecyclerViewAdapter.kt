package com.android.coronaapiwithkotlin.ui.Emergency.Goverment

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hippocompany.coronareport.R


class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewHolder>() {



    val nameList= listOf<String>("ဦးသိဏ်းအေး","ဦးပုငယ်","ဦးသောင်းတင် ","ဦးမင်းမင်းလှိုင်","ဦးအောင်ခိုင်ဦး","ဦးအောင်ကျန် ","ဦးနန္ဒအောင် ",
        "ဦးရဲနိုင်","ဦးစိုးမိုးနိုင်","ဦး၀င်းခိုင်","ဦးတင်ဇော်","ဦးဌေးလှိုင်","ဦးရန်နိုင်စိုး","ဦးမောင်ဆွေ","ဦးမောင်ဌေး","ဦးတိုးလွင်",
        "ဦးထိန်လင်းအောင်","ဦးကျော်သူစိုး","ဦး၀င်းဇော်ဦး","ဦးသန်းဌေး၀င်း","ဦးထွန်းနိုင်စိုး","ဦးစောဦး","ဦးဌေး၀င်း","ဦးအောင်ငယ်","ဦးပေါ်လွင်",
        "ဦးနောင်နီ","ဦးသန်းကို","ဦးယဉ်ထွေး","ဦးမောင်မျိုး","ဦးမင်းမင်းဦး","ဦးမျိုးလွင် ","ဦးအောင်မြတ်သူ","ဦး၀င်းချို","ဦးမျိုးသိန်း")
    val locationList= listOf<String>("နောက်လယ်ရပ်ကွက်","ဈေးတန်း","ဆိပ်ငယ်ရပ်ကွက်","တလိုင်းစုရပ်ကွက်","ထား၀ယ်စုရပ်ကွက်","မြစ်ငယ်ရပ်ကွက်","ကန်ခေါင်းရပ်ကွက်","ကန်ဖျားရပ်ကွက်"
        ,"ကန်ကြီးရပ်ကွက်","အလယ်ကျွန်းရပ်ကွက်","မြိတ်တောင်ရပ်ကွက်","ရေပုန်းရပ်ကွက်","ကလွင်ကျေးရွာ","မြိတ်တောင်ကျေးရွာ","စန္ဒ၀တ်ကျေးရွာ","ကျောက်ဖျားကျေးရွာ","သမုတ်ကျေးရွာ"
        ,"ပဆွပ်ကျေးရွာ","သဘွတ်ကျေးရွာ","ပင်းအိုကျေးရွာ","အလယ်ချောင်းကျေးရွာ","ပပြင်ကျေးရွာ","အင်္ဂမော်ကျေးရွာ","ပသောင်းကျေးရွာ","တောင်းရှည်ကျေးရွာ","တညက်ကျေးရွာ"
        ,"နန်းတော်ရာကျေးရွာ","မင်းသန်းကျေးရွာ","စလွန်းကျေးရွာ ","ကဟန်ကျေးရွာ","မဇောကျေးရွာ","တုံးဗျောကျေးရွာ","ပြင်းငယ်ကျေးရွာ","သစ်ယာ၀ကျေးရွာ")
    val phlist= listOf<String>("09252856969","09422197716","09262484722","09790190107","095641040 ","09772473499","09422195607","0941004929"
        ,"09258108108","098763168","09268877781","09254698298","09429341860","09781905925","09786679224","09422193580","09422220026","0949872410"
        ,"09457336089","09262930622","09455670268","0949873351","09264256015","09250170337","09250838236","09402955542","09960469077","09254171346"
        ,"09250467415","09266070537","098760359","09454393922","09792598578","09764805977")
    //private lateinit var context:Context



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.custom_list,parent,false)
        return RecyclerViewHolder(view)
        }
    override fun getItemCount(): Int {
        return nameList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.nameTxt.text=nameList[position]
        holder.locationTxt.text=locationList[position]

       holder.itemView.setOnClickListener{ v: View -> Unit
           val context=holder.nameTxt.context
          Log.i("Log Index = ",nameList[position])
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phlist.get(position)))

           context.startActivity(intent)
        }
    }

}