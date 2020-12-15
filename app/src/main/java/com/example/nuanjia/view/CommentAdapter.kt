package com.example.nuanjia.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.nuanjia.R

class CommentAdapter(
    var context: Context, var list: ArrayList<HashMap<String, Any>>, val resources: Int
) :BaseAdapter(){
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    inner class ViewHolder(
        var profile: ImageView,
        var name: TextView,
        var tvContent:TextView,
        var time:TextView

        )

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View
        val viewHolder:ViewHolder
        if (convertView == null){
            view = LayoutInflater.from(parent?.context).inflate(R.layout.comment_item,parent,false)
            val profile : ImageView = view.findViewById(R.id.profile_photo)
            val name: TextView = view.findViewById(R.id.name)
            val tvContent:TextView = view.findViewById(R.id.tv_content)
            val time:TextView = view.findViewById(R.id.time)

            viewHolder = ViewHolder(profile, name,tvContent,time)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var map = list[position]
        with(viewHolder){
            profile.setImageResource(map["profile"] as Int)
            name.text = map["name"] as String
            tvContent.text = map["tvContent"] as String
            time.text = map["time"] as String
        }
        return view
    }

}