package com.example.extraa_edge.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.extraa_edge.activity.MainActivity
import com.example.extraa_edge.OnItemClicklistner
import com.example.extraa_edge.R
import com.example.extraa_edge.model.RocketDetailsList
import com.squareup.picasso.Picasso

class MyRecyclerAdapter(rocketDetailsList: RocketDetailsList) : RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>() {

    lateinit var rvItemClicklistner: OnItemClicklistner
    private var rocketDetailsList = rocketDetailsList
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(
            R.layout.rocket_lessdetails, parent, false
        )

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.rocketName.text = rocketDetailsList[position].name
        holder.companyName.text = rocketDetailsList[position].company
        holder.engineCount.text = rocketDetailsList[position].engines.number.toString()


        holder.ll_top_id.setOnClickListener{

            rvItemClicklistner.onItemRocketClick(rocketDetailsList[position].id)
            Log.d("holder.ll_top_id", "clicked")

        }

        Log.d("rocket image url ", rocketDetailsList[position].flickr_images.toString() )
        Picasso.get().load(rocketDetailsList[position].flickr_images[0]).
        into(holder.rocketImage)

    }

    override fun getItemCount(): Int {
    return rocketDetailsList.size
    }


    fun update(context: MainActivity){
        this.context = context
        this.rvItemClicklistner = context
    }




    class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){

        var rocketName = itemView.findViewById<TextView>(R.id.rocket_name)
        var companyName = itemView.findViewById<TextView>(R.id.company_name)
        var engineCount = itemView.findViewById<TextView>(R.id.engine_count)
        var rocketImage = itemView.findViewById<ImageView>(R.id.rocket_image)
        var ll_top_id = itemView.findViewById<LinearLayout>(R.id.lltop_id)








    }





}

