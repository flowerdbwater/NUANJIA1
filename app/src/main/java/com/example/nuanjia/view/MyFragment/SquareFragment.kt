package com.example.nuanjia.view.MyFragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nuanjia.R
import com.example.nuanjia.SpacesItemDecoration
import com.example.nuanjia.view.Square.MyDynamicActivity
import com.example.nuanjia.view.SquareAdapter
import kotlinx.android.synthetic.main.fragment_square.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SquareFragment : Fragment(){

    private var list: ArrayList<HashMap<String, Any>> = ArrayList<HashMap<String, Any>>()
    var map: HashMap<String, Any> = HashMap<String, Any>()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        map["profile_photo"] = R.drawable.profile
        map["name"] = "花水水"
        map["time"] = "5:20"
        map["tvContent"] = "welcome!!!汪苏泷汪苏泷，苏音唯美，爱泷不悔！！！汪苏泷汪苏泷，苏音唯美，爱泷不悔！！！"
        map["ivContent"] = R.drawable.square_show
        list.add(map)

        map["profile_photo"] = R.drawable.profile
        map["name"] = "花水水"
        map["time"] = "5:20"
        map["tvContent"] = "welcome!!!汪苏泷汪苏泷，苏音唯美，爱泷不悔！！！汪苏泷汪苏泷，苏音唯美，爱泷不悔！！！"
        map["ivContent"] = R.drawable.square_show
        list.add(map)

        map["profile_photo"] = R.drawable.profile
        map["name"] = "花水水"
        map["time"] = "5:20"
        map["tvContent"] = "welcome!!!汪苏泷汪苏泷，苏音唯美，爱泷不悔！！！汪苏泷汪苏泷，苏音唯美，爱泷不悔！！！"
        map["ivContent"] = R.drawable.square_show
        list.add(map)

        map["profile_photo"] = R.drawable.profile
        map["name"] = "花水水"
        map["time"] = "5:20"
        map["tvContent"] = "welcome!!!汪苏泷汪苏泷，苏音唯美，爱泷不悔！！！汪苏泷汪苏泷，苏音唯美，爱泷不悔！！！"
        map["ivContent"] = R.drawable.square_show
        list.add(map)


        val manager = LinearLayoutManager(this.activity)
        recyclerview.layoutManager = manager

        //给动态之间添加间隔
        val space = 25
        val spacesItemDecoration = SpacesItemDecoration(space)
        recyclerview.addItemDecoration(spacesItemDecoration)

        val adapter = SquareAdapter(list)
        if (recyclerview != null) {
            recyclerview.adapter = adapter
        }

        //点击头像进入我的动态
        profile_photo.setOnClickListener{
            val intent = Intent(activity, MyDynamicActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_square, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SquareFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            SquareFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

}

