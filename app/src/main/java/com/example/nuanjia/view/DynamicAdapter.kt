package com.example.nuanjia.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.nuanjia.R
import com.example.nuanjia.view.MyFragment.SquareFragment

class DynamicAdapter(
    val context: SquareFragment,
    var list: ArrayList<HashMap<String, Any>>,
    val resourceId:Int) : BaseAdapter() {
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
        var profile:ImageView,
        var name:TextView,
        var time:TextView,
        var tvContent:TextView,
        var ivContent:ImageView
    )

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View
        val viewHolder:ViewHolder
        if(convertView==null){
            view = LayoutInflater.from(parent?.context).inflate(R.layout.dynamic_item,parent,false)
            val profile :ImageView = view.findViewById(R.id.profile_photo)
            val name:TextView = view.findViewById(R.id.name)
            val time:TextView = view.findViewById(R.id.time)
            val tvContent:TextView = view.findViewById(R.id.tv_content)
            val ivContent:ImageView = view.findViewById(R.id.iv_content)

            viewHolder = ViewHolder(profile,name,time,tvContent,ivContent)
            view.tag = viewHolder


        }else{
            view=convertView
            viewHolder = view.tag as ViewHolder
        }

        val map: java.util.HashMap<String, Any> = list[position]
        with(viewHolder){
            profile.setImageResource(map["profile_photo"] as Int)
            name.text = map["name"] as String
            time.text = map["time"] as String
            tvContent.text = map["tvContent"] as String
            ivContent.setImageResource(map["ivContent"] as Int)
        }
        return view
    }
}