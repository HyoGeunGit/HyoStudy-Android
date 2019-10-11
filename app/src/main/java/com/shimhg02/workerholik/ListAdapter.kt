package com.shimhg02.workerholik


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_youtube.view.*

/**
 * Created by shimhg02 on 2018-12-11.
 */

class ListAdapter(val userList:ArrayList<Youtube>): RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    //아이템의 갯수를 설정해줍니다 (저 안의 숫자는 보통 .size로 지정해줍니다.)
    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_youtube, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bindItems(data : Youtube){
            itemView.name_tv.text = data.name
            itemView.sub_tv.text = data.sub
            //각각의 아이템 클릭할때의 이벤트를 띄워줍니다.
            itemView.setOnClickListener {

                Toast.makeText(itemView.context, "'${data.name}'를 클릭했습니다.", Toast.LENGTH_LONG).show()
            }
        }

    }

}