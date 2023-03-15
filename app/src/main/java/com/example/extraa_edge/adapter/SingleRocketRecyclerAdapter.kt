package com.example.extraa_edge.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.extraa_edge.R
import com.squareup.picasso.Picasso

class SingleRocketRecyclerAdapter(singleRocketImages: ArrayList<String> , private val context: Context) :
    RecyclerView.Adapter<SingleRocketRecyclerAdapter.MyViewHolder>() {

    var rocketImages = singleRocketImages


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SingleRocketRecyclerAdapter.MyViewHolder {


        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(
            R.layout.single_rocket_rv, parent, false
        )

        return SingleRocketRecyclerAdapter.MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return rocketImages.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

//        holder.singleImage.get(position).let { Log.d("rocket image url ", it.toString()) }

        Picasso.get().load(rocketImages[position]).into(holder.singleImage)
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var singleImage = itemView.findViewById<ImageView>(R.id.image)


    }


}

