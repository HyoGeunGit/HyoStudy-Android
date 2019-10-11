package com.shimhg02.workerholik


import android.annotation.SuppressLint
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override var viewId: Int = R.layout.activity_main
    override var toolbarId: Int? = R.id.toolbar
    private lateinit var toast: Toast
    private var backKeyPressedTime: Long = 200
    private var mViewPager: ViewPager? = null

    @SuppressLint("ShowToast")
    override fun onCreate() {
        onRestart()
        showActionBar()
        mViewPager = findViewById(R.id.viewPager)
        mViewPager!!.adapter = PagerAdapter(supportFragmentManager)
        mViewPager!!.currentItem = 0

        val tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(mViewPager)
        // set icons
        tabLayout.getTabAt(0)!!.setIcon(R.drawable.homes)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.books)
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.profilepic)
//        linear_in_friend.visibility = View.VISIBLE
//        title_toolbar.visibility = View.GONE
        mViewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
//        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab){
//                val pos = tab.position
//                if(pos==0){
//                    tabLayout.getTabAt(0)!!.setIcon(R.drawable.people_color)
//                    linear_in_friend.visibility = View.VISIBLE
//                    title_toolbar.visibility = View.GONE
//                    mainViewDot.visibility = View.VISIBLE
//                    toolbar.visibility = View.VISIBLE
//                    makechat.visibility = View.GONE
//                    search_gal.visibility = View.GONE
//                    set.visibility = View.GONE
//                }
//                if(pos==1){
//                    tabLayout.getTabAt(1)!!.setIcon(R.drawable.oval)
//                    linear_in_friend.visibility = View.GONE
//                    title_toolbar.visibility = View.VISIBLE
//                    title_toolbar.text = "채팅"
//                    mainViewDot.visibility = View.VISIBLE
//                    toolbar.visibility = View.VISIBLE
//                    makechat.visibility = View.VISIBLE
//                    search_gal.visibility = View.VISIBLE
//                    set.visibility = View.VISIBLE
//                    makechat.setOnClickListener {
//                        startActivity(Intent(this@MainActivity, MakeGroupActivity::class.java))
//                    }
//                }
//                if(pos==2){
//                    tabLayout.getTabAt(2)!!.setIcon(R.drawable.star_color)
//                    linear_in_friend.visibility = View.GONE
//                    title_toolbar.visibility = View.VISIBLE
//                    title_toolbar.text = "인기채팅방"
//                    mainViewDot.visibility = View.GONE
//                    toolbar.visibility = View.GONE
//                    makechat.visibility = View.GONE
//                    search_gal.visibility = View.GONE
//                    set.visibility = View.GONE
//                }
//                if(pos==3) {
//                    tabLayout.getTabAt(3)!!.setIcon(R.drawable.threedot_color)
//                    linear_in_friend.visibility = View.GONE
//                    title_toolbar.visibility = View.VISIBLE
//                    title_toolbar.text = "설정"
//                    makechat.visibility = View.GONE
//                    mainViewDot.visibility = View.VISIBLE
//                    toolbar.visibility = View.VISIBLE
//                    search_gal.visibility = View.GONE
//                    set.visibility = View.GONE
//                }
//            }
//            override fun onTabUnselected(tab: TabLayout.Tab) {
//                tabLayout.getTabAt(0)!!.setIcon(R.drawable.people)
//                tabLayout.getTabAt(1)!!.setIcon(R.drawable.oval_empty_oval)
//                tabLayout.getTabAt(2)!!.setIcon(R.drawable.star)
//                tabLayout.getTabAt(3)!!.setIcon(R.drawable.three_dot_empty_oval)
//            }

//            override fun onTabReselected(tab: TabLayout.Tab) { }
//        })

        /* viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
             override fun onPageScrollStateChanged(state: Int) {
             }
             override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
             }
             override fun onPageSelected(position: Int) {
             }
         })*/
    }

    override fun onBackPressed() {
        val delay = 500
        when {
            System.currentTimeMillis() > backKeyPressedTime + delay -> {
                backKeyPressedTime = System.currentTimeMillis()
                return
            }
            System.currentTimeMillis() <= backKeyPressedTime + delay -> {
                this.finish()
            }
        }

    }

    inner class PagerAdapter(supportFragmentManager: FragmentManager) : FragmentStatePagerAdapter(supportFragmentManager) {

        override fun getItem(position: Int): Fragment {

            return when (position) {
                0 ->
                    JobFragment()
                1 ->
                    YoutubeFragment()
                2 ->
                    ProfileFragment()
                else ->
                    ProfileFragment()
            }
        }

        override fun getCount(): Int = 3
    }
}