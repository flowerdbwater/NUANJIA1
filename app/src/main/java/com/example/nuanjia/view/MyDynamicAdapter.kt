package com.example.nuanjia.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nuanjia.R
import com.example.nuanjia.view.Square.DynamicContent

class MyDynamicAdapter(var list: ArrayList<HashMap<String, Any>>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val Top = 0
    private val Other = 1

    internal class ViewHolderTop(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val qqh: Button= itemView.findViewById(R.id.qqh)
//        val questionAnswers: Button= itemView.findViewById(R.id.question_answers)
    }

    internal class ViewHolderOther(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profile: ImageView = itemView.findViewById(R.id.profile_photo)
        val name: TextView = itemView.findViewById(R.id.name)
        val time:TextView = itemView.findViewById(R.id.time)
        val tvContent: TextView = itemView.findViewById(R.id.tv_content)
        val ivContent: ImageView = itemView.findViewById(R.id.iv_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == Top) {
            //Top
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.mydynamic_top,
                parent,
                false
            )
            ViewHolderTop(view)
        } else {
            //Other及其他
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.dynamic_item,
                parent,
                false
            )
            val viewHolderOther = ViewHolderOther(view)
            viewHolderOther.itemView.setOnClickListener {
                val intent = Intent(view.context, DynamicContent::class.java)
                view.context.startActivity(intent)
            }
            ViewHolderOther(view)

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val map: java.util.HashMap<String, Any> = list[position]
        val viewType = holder.itemViewType //获取item类型

        if (viewType == Top) {
            //Top
            val topHolder = holder as ViewHolderTop
            with(topHolder){
            }
        } else {
            //Other
            val otherHolder = holder as ViewHolderOther
            //将position保存在itemView的Tag中，以便点击时进行获取
            with(otherHolder){
                profile.setImageResource(map["profile_photo"] as Int)
                name.text = map["name"] as String
                time.text = map["time"] as String
                tvContent.text = map["tvContent"] as String
                ivContent.setImageResource(map["ivContent"] as Int)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            Top
        } else {
            Other
        }
    }
}
//class MyDynamicAdapter(
//    val context: Context,
//    var list: ArrayList<HashMap<String, Any>>
//) : BaseAdapter() {
//    override fun getCount(): Int {
//        return list.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return list[position]
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    inner class ViewHolder(
//        var profile: ImageView,
//        var name: TextView,
//        var time: TextView,
//        var tvContent: TextView,
//        var ivContent: ImageView
//    )
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val view: View
//        val viewHolder:ViewHolder
//        if(convertView==null){
//            view = LayoutInflater.from(parent?.context).inflate(R.layout.my_dynamic_item,parent,false)
//            val profile : ImageView = view.findViewById(R.id.profile_photo)
//            val name: TextView = view.findViewById(R.id.name)
//            val time: TextView = view.findViewById(R.id.time)
//            val tvContent: TextView = view.findViewById(R.id.tv_content)
//            val ivContent: ImageView = view.findViewById(R.id.iv_content)
//
//            viewHolder = ViewHolder(profile,name,time,tvContent,ivContent)
//            view.tag = viewHolder
//
//
//        }else{
//            view=convertView
//            viewHolder = view.tag as ViewHolder
//        }
//
//        var map: java.util.HashMap<String, Any> = list[position]
//        with(viewHolder){
//            profile.setImageResource(map["profile_photo"] as Int)
//            name.text = map["name"] as String
//            time.text = map["time"] as String
//            tvContent.text = map["tvContent"] as String
//            ivContent.setImageResource(map["ivContent"] as Int)
//        }
//        return view
//    }
//}