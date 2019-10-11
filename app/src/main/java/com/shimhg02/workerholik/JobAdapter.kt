package com.shimhg02.workerholik


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycler2.view.*
import java.util.ArrayList


internal class JobAdapter(private val dataList: ArrayList<ProfileData>): RecyclerView.Adapter<JobAdapter.ViewHolder>() {




    //아이템의 갯수를 설정해줍니다 (저 안의 숫자는 보통 .size로 지정해줍니다.)
    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler2, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(dataList[position])
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bindItems(data: ProfileData){
//            itemView.molle_my_token.text = "QUsYdiJCZP66lesOEYil"
//            itemView.name_tv_friend.text = data.nickName
            itemView.name_tv.text = data.name
//            //각각의 아이템 클릭할때의 이벤트를 띄워줍니다.
            itemView.setOnClickListener {
                //                //여기서 토스트메시지를 띄워줍니다.
                val intent = Intent(itemView.context, GoGoActivity::class.java)
//                intent.putExtra("chatName", itemView.molle_my_token.text.toString() + itemView.molle_token.text.toString())
//                intent.putExtra("userName", "User <Firebase Set>")
//                intent.putExtra("chatRoomName", itemView.name_tv_friend.text.toString())
                itemView.context.startActivity(intent)
            }
        }

    }

}