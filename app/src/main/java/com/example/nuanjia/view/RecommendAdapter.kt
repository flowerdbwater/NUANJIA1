package com.example.nuanjia.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nuanjia.R
import com.example.nuanjia.view.MyFragment.HomeFragment

class RecommendAdapter(private val recommendList: ArrayList<HomeFragment.Recommend>):
    RecyclerView.Adapter<RecommendAdapter.ViewHolder>() {

    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val recommendImage:ImageView = view.findViewById(R.id.recommend_image)
        val recommendInformation:TextView = view.findViewById(R.id.recommend_information)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recommend_item,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecommendAdapter.ViewHolder, position: Int) {
        val recommend = recommendList[position]
        holder.recommendImage.setImageResource(recommend.image)
        holder.recommendInformation.text = recommend.information
    }

    override fun getItemCount(): Int {
        return recommendList.size
    }
}