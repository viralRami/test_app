package com.example.test_app

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val displayStringList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayStringList.add("Alphabet")
        var alphabet = 'A'
        while (alphabet <= 'Z') {
            displayStringList.add(alphabet.toString())
            ++alphabet
        }
        displayStringList.add("Numbers")
        var number = 1
        while (number <= 100) {
            displayStringList.add(number.toString())
            ++number
        }
        rvAlphabetList.layoutManager=LinearLayoutManager(this)
    rvAlphabetList.adapter=AlphabetAdapter(this,displayStringList)
    }

    inner class AlphabetAdapter(var mContext: Context, val list: List<String>) :
        RecyclerView.Adapter<AlphabetAdapter.ViewHolder>() {
        inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
          val txtText=item.findViewById<TextView>(R.id.txtAlphabet)
            fun bind(text:String) {
                Log.d("latter:-",text)
    txtText.text=text
            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
            LayoutInflater.from(mContext).inflate(R.layout.adapter_layout, parent, false)
        )


        override fun getItemCount(): Int = list.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
           holder.bind(list[position])
        }


    }
}