package com.example.nuanjia.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nuanjia.R
import com.example.nuanjia.view.Square.DynamicContent
import com.example.nuanjia.view.Square.QqhActivity
import com.example.nuanjia.view.Square.QuestionAnswerActivity


class SquareAdapter(var list: ArrayList<HashMap<String, Any>>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    private val Top = 0
    private val Other = 1

    internal class ViewHolderTop(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val qqh: Button = itemView.findViewById(R.id.qqh)
        val questionAnswer: Button= itemView.findViewById(R.id.question_answer)
        val dynamicNV:com.google.android.material.bottomnavigation.BottomNavigationView = itemView.findViewById(R.id.dynamic_NV)
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
                R.layout.square_top,
                parent,
                false
            )
            val viewHolderTop = ViewHolderTop(view)
            with(viewHolderTop){
                //悄悄话
                qqh.setOnClickListener {
                    val intent = Intent(view.context, QqhActivity::class.java)
                    view.context.startActivity(intent)
                }
                //问答
                questionAnswer.setOnClickListener {
                    val intent = Intent(view.context, QuestionAnswerActivity::class.java)
                    view.context.startActivity(intent)
                }
                dynamicNV.setOnNavigationItemSelectedListener {
                    when(it.itemId){
                        R.id.recommend_dynamic -> {
                            //点击推荐动态，显示数据为推荐动态的数据

                        }
                        R.id.focus_dynamic ->{
                            //点击关注动态，显示数据为关注动态数据

                        }

                    }
                    true
                }
            }
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
                //点击动态进入动态内容详细页面
                val intent = Intent(view.context, DynamicContent::class.java)
                view.context.startActivity(intent)
            }
            ViewHolderOther(view)

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val map: java.util.HashMap<String, Any> = list[position]
        val viewType = holder.itemViewType //获取item类型
        //上半部分悄悄话、问答、动态切换按钮
        if (viewType == Top) {
            //Top
            val topHolder = holder as ViewHolderTop
            with(topHolder){

            }
        } else {
            //Other动态内容
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

