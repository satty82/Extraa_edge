package com.example.extraa_edge.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.extraa_edge.R
import com.example.extraa_edge.adapter.SingleRocketRecyclerAdapter
import com.example.extraa_edge.databinding.ActivitySingleRocketBinding
import com.example.extraa_edge.model.RocketDetailsListItem

class SingleRocketActivity : AppCompatActivity() {

    lateinit var binding: ActivitySingleRocketBinding
    lateinit var rocketData : RocketDetailsListItem
    lateinit var mySingleRocketRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_single_rocket)

        val intent = getIntent()
        binding.activeStatus.text = intent.getBooleanExtra("active",false).toString()
        binding.cost.text  = intent.getIntExtra("cost",0).toString()
        binding.description.text  = intent.getStringExtra("description")
        binding.name.text  = intent.getStringExtra("name")
        val meter = intent.getDoubleExtra("height meter",0.0).toString()
        val feet = intent.getDoubleExtra("height feet",0.0).toString()
        binding.height.text = meter +"/"+feet
        binding.successRate.text  = intent.getIntExtra("success",0).toString()
        binding.wiki.text  = intent.getStringExtra("wiki")


        val images = intent.getStringArrayListExtra("images")!!.toCollection(ArrayList())
        Log.d("singleRocket", images.toString())

        Log.d("singleRocket array ", images.toString())


        mySingleRocketRecyclerView = findViewById(R.id.singleRocketRV)
        mySingleRocketRecyclerView.layoutManager = LinearLayoutManager(this)

        mySingleRocketRecyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        mySingleRocketRecyclerView.adapter = SingleRocketRecyclerAdapter(images, this)



    }

    override fun onBackPressed() {
        super.onBackPressed()

        this.finish()
    }
}