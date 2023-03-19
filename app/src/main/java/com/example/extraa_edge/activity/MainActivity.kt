package com.example.extraa_edge.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.extraa_edge.OnItemClicklistner
import com.example.extraa_edge.R
import com.example.extraa_edge.adapter.MyRecyclerAdapter
import com.example.extraa_edge.api.RetrofitHelper
import com.example.extraa_edge.api.RocketDetailsService
import com.example.extraa_edge.model.RocketDetailsListItem
import com.example.extraa_edge.repository.RocketRepository
import com.example.extraa_edge.viewmodels.MainViewModel
import com.example.extraa_edge.viewmodels.MainViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), OnItemClicklistner {

    lateinit var mainViewModel: MainViewModel
    lateinit var mainViewModelID: MainViewModel

    lateinit var myRecyclerView: RecyclerView
    lateinit var adapter : MyRecyclerAdapter
    lateinit var repository : RocketRepository
    lateinit var textView : EditText
    var isEnable = true
    var bundle = Bundle()

    var name:String? = null
    var age = 34


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rocketDetailsService =
            RetrofitHelper.getInstance().create(RocketDetailsService::class.java)

        repository = RocketRepository(rocketDetailsService)

        textView = findViewById(R.id.text)
        myRecyclerView = findViewById(R.id.recycler_View)
        myRecyclerView.layoutManager = LinearLayoutManager(this)

        myRecyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository,"0")).get(MainViewModel::class.java)

        if (savedInstanceState!= null) {
            textView.setText(savedInstanceState.getString("saveIt"))
            Log.d("mainActivity saved", savedInstanceState.getString("saveIt").toString())
        }


        savedInstanceState?.let {

        }


        mainViewModel.rocket.observe(this) {
            Log.d("SATTY", it.toString())

            it.let {  }

            adapter = MyRecyclerAdapter(it)
            myRecyclerView.adapter = adapter

            adapter.update(this@MainActivity)

        }

        name!!.let{

              Log.d("mainActivity let", it)

        }

//        name!!.let{
//            Log.d("mainActivity ", it)
//        }

        val lambda1 = {x:Int, y:Int -> x+y}
        val line = {
            val a = 23
            a
            "Satyam"
        }

        val coroutine = CoroutineScope(Dispatchers.Main)
        val job1 = coroutine.launch {
            println("loadingg..")
            delay(3000)

        }
        val job2 = CoroutineScope(Dispatchers.IO)


    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)


        Log.d("mainActivity onRestate", savedInstanceState?.getString("saveIt").toString())

        textView.setText(savedInstanceState?.getString("saveIt"))
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("saveIt",textView.text.toString())
        Log.d("mainActivity onSavState"," called")

    }


    override fun onItemRocketClick(id: String) {

        Log.d("onItemRocketClick ", "inside $id")

        mainViewModelID = ViewModelProvider(this, MainViewModelFactory(repository, id)).get(MainViewModel::class.java)
        mainViewModelID.callVM(id)
        mainViewModel.rocketId.observe(this) {
            Log.d("onItemRocketClick ", it.toString())

//            RocketDetailsListItem(it.active,it.boosters,it.company,it.cost_per_launch,it.country,it.description,it.diameter,it.engines,
//                it.first_flight,it.first_stage,it.flickr_images,it.height,it.id,it.landing_legs,it.mass,it.name,it.payload_weights
//            ,it.second_stage,it.stages,it.success_rate_pct,it.type,it.wikipedia
//            )

            val intent = Intent(this, SingleRocketActivity ::class.java)

            intent.putExtra("active",it.active)
            intent.putExtra("cost",it.cost_per_launch)
            intent.putExtra("description",it.description)
            intent.putExtra("name",it.name)
            intent.putExtra("height feet",it.height.feet)
            intent.putExtra("height meter",it.height.meters)
            intent.putExtra("success",it.success_rate_pct)
            intent.putStringArrayListExtra("images",it.flickr_images)
            intent.putExtra("wiki",it.wikipedia)

            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY )
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

            startActivity(intent)

        }

    }

    override fun onStop() {
        super.onStop()

         bundle.putString("saveIt",textView.text.toString())

        onSaveInstanceState(bundle)

        name ?: return


//        bundle?.putString("saveIt",textView.text.toString())
//        Log.d("mainActivity ","onStop called")

    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("mainActivity ","onDestroy called")


    }

}