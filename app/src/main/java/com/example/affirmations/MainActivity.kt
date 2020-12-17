package com.example.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the data
        val myDataSet = Datasource().loadAffirmations()

        //get the reference for recyclerView inside activity_main
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        //tell the recyclerView which adapter to use with what dataset
        recyclerView.adapter = ItemAdapter(this,  myDataSet)

        //since my dataset size does not change, setHasFixedSize is true
        //setting this improves performance
        recyclerView.setHasFixedSize(true)






    }
}