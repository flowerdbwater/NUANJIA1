package com.example.nuanjia.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.nuanjia.R
import com.example.nuanjia.Tool
import com.example.nuanjia.view.MyFragment.HealthFragment
import com.example.nuanjia.view.MyFragment.HomeFragment
import com.example.nuanjia.view.MyFragment.PersonFragment
import com.example.nuanjia.view.MyFragment.SquareFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {

    //初始化Fragment集合
    private var fragmentList: MutableList<Fragment> = mutableListOf()
    //声明fragment
    private lateinit var homeFragment: HomeFragment
    private lateinit var squareFragment: SquareFragment
    private lateinit var healthFragment: HealthFragment
    private lateinit var personFragment: PersonFragment

    //用作显示隐藏Fragment所用
    private lateinit var currentFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        val tool = Tool()
        tool.setWindowStatusBarColor(this,R.color.green)
        
        setContentView(R.layout.activity_main)

        //设置RadioGroup的监听
        rg_tab_bar.setOnCheckedChangeListener(this)
        //初始化Fragment
        initFragment()
        //设置默认Fragment
        initSetNormalFragment()
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        val fm = supportFragmentManager
        when (checkedId) {
            R.id.rb_home ->
                showFragment(fragmentList[0], fm)
            R.id.rb_square ->
                showFragment(fragmentList[1], fm)
            R.id.rb_health ->
                showFragment(fragmentList[2],fm)
            R.id.rb_person ->
                showFragment(fragmentList[3],fm)
        }
    }

    //将fragment添加进集合
    private fun initFragment() {
        currentFragment = Fragment()
        homeFragment = HomeFragment.newInstance()
        squareFragment = SquareFragment.newInstance()
        healthFragment = HealthFragment.newInstance()
        personFragment = PersonFragment.newInstance()

        fragmentList.add(homeFragment)
        fragmentList.add(squareFragment)
        fragmentList.add(healthFragment)
        fragmentList.add(personFragment)
    }

    private fun initSetNormalFragment() {
        val fm = supportFragmentManager
        showFragment(fragmentList[0], fm)
    }


    private fun showFragment(fragment: Fragment, fm: FragmentManager) {
        //判断当前显示的是否是需要展示的Framgnet，可以省略不必要步骤
        if (currentFragment != fragment) {
            //隐藏当前Fragment
            val transaction = fm.beginTransaction()
            transaction.hide(currentFragment)
            //将fragment替换成目前传入的fragment
            currentFragment = fragment
            //判断当前fragment是否添加进事务中
            if (!fragment.isAdded) {
                //添加显示
                transaction.add(R.id.fl_contain, fragment).show(fragment).commit()
            } else {
                //显示
                transaction.show(fragment).commit()
            }
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(requestCode == 1)
//    }
}