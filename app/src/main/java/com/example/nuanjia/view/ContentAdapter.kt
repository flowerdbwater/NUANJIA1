package com.example.nuanjia.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.recyclerview.widget.RecyclerView
import com.example.nuanjia.R
import com.example.nuanjia.view.Square.DynamicContent

class ContentAdapter(var list: ArrayList<HashMap<String, Any>>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val Top = 0
    private val Other = 1

    internal class ViewHolderTop(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val qqh: Button= itemView.findViewById(R.id.qqh)
//        val questionAnswers: Button= itemView.findViewById(R.id.question_answers)
    }

    internal class ViewHolderOther(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profile: ImageView = itemView.findViewById(R.id.profile_photo)
        val name: TextView = itemView.findViewById(R.id.name)
        val time: TextView = itemView.findViewById(R.id.time)
        val tvContent: TextView = itemView.findViewById(R.id.tv_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == Top) {
            //Top
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.dynamic_content_top,
                parent,
                false
            )
            ViewHolderTop(view)
        } else {
            //Other及其他
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.comment_item,
                parent,
                false
            )
            ViewHolderOther(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val comment = list[position]
        val viewType = holder.itemViewType //获取item类型

        if (viewType == Top) {
            //Top
            val topHolder = holder as ViewHolderTop
            with(topHolder){

            }
        } else {
            //Other
            val otherHolder = holder as ViewHolderOther
            with(otherHolder){
                profile.setImageResource(comment["profile"] as Int)
                name.text = comment["name"] as String
                tvContent.text = comment["tvContent"] as String
                time.text = comment["time"] as String
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