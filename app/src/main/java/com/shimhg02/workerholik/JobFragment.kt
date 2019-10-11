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
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class JobFragment : Fragment() {

    val PREFERENCE = "com.shimhg02.worker"
    private val items = java.util.ArrayList<ProfileData>()
    private var recyclerView: RecyclerView? = null
    private var recyclerView2: RecyclerView? = null
    private var adapter: ProfileAdapter? = null
    private var adapters: JobAdapter? = null
    @SuppressLint("WrongConstant")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_jobs, container, false)
//
//        view.fab.setOnClickListener {
//            var intent1 = Intent(getActivity(), AddFriendActivity::class.java)
//            startActivity(intent1)
//        }
        recyclerView = view!!.findViewById(R.id.recycle)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        recyclerView?.adapter =  ProfileAdapter(items)
        adapter = recyclerView!!.adapter as ProfileAdapter?
        val sharedPref = activity!!.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE)
        val username = sharedPref.getString("userName", "")
        val token = sharedPref.getString("token","")

        Client.retrofitService.getData(token).enqueue(object : Callback<ArrayList<ProfileData>> {
            override fun onResponse(call: Call<ArrayList<ProfileData>>?, response: Response<ArrayList<ProfileData>>?) {
                val repo = response!!.body()

                when (response.code()) {
                    200 -> {
                        repo!!.indices.forEach {
                            items += ProfileData(repo[it].name)
                            recyclerView!!.adapter?.notifyDataSetChanged()
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<ProfileData>>?, t: Throwable?) {
                Log.v("C2cTest", "fail!!")
            }
        })

        recyclerView2 = view!!.findViewById(R.id.recycle2)
        recyclerView2?.setHasFixedSize(true)
        recyclerView2?.layoutManager = LinearLayoutManager(context, LinearLayout.HORIZONTAL, false)
        recyclerView2?.adapter =  JobAdapter(items)
        adapters = recyclerView2!!.adapter as JobAdapter?
        Client.retrofitService.getData(token).enqueue(object : Callback<ArrayList<ProfileData>> {
            override fun onResponse(call: Call<ArrayList<ProfileData>>?, response: Response<ArrayList<ProfileData>>?) {
                val repo = response!!.body()

                when (response.code()) {
                    200 -> {
                        repo!!.indices.forEach {
                            items += ProfileData(repo[it].name)
                            recyclerView2!!.adapter?.notifyDataSetChanged()
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<ProfileData>>?, t: Throwable?) {
                Log.v("C2cTest", "fail!!")
            }
        })
        return view
    }



}