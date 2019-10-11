package com.shimhg02.workerholik


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_youtube.*
import kotlinx.android.synthetic.main.fragment_youtube.view.*

/**
 * Created by Kinetic on 2018-06-02.
 */
class YoutubeFragment : Fragment() {

    @SuppressLint("WrongConstant")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_youtube, container, false)
//
//        view.fab.setOnClickListener {
//            var intent1 = Intent(getActivity(), AddFriendActivity::class.java)
//            startActivity(intent1)
//        }
        val userList = arrayListOf(
            Youtube("교통 채보", "교통의 채보를 알려줘요!" ),
            Youtube("재활 채보", "재활운동 채보를 알려줘요!" )
        )

        //레이아웃매니저를 설정해줍니다.
        view.youtube_recycler.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        view.youtube_recycler.setHasFixedSize(true)

        //어댑터도 설정해줍니다.
        view.youtube_recycler.adapter = ListAdapter(userList)
        return view
    }



}