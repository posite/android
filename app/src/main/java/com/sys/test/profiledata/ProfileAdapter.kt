package com.sys.test.profiledata

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sys.test.R
import com.sys.test.activity.ThirdActivity

class ProfileAdapter(private val datas : ArrayList<ProfileData>,private val context: Context) : RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.monttakrecycler,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val txtTitle: TextView = itemView.findViewById(R.id.tv_rv_title)
        private val txtAddress: TextView = itemView.findViewById(R.id.tv_rv_address)
        private val imgProfile: ImageView = itemView.findViewById(R.id.img_rv_photo)

        fun bind(data: ProfileData) {
            txtTitle.text = data.title
            txtAddress.text = data.roadaddress
            Glide.with(itemView).load(data.thumbnailpath).into(imgProfile)
            itemView.setOnClickListener{
                Intent(context,ThirdActivity::class.java).apply {
                    putExtra("data", data)
                }.run{context.startActivity(this)}
            }
        }
    }
    fun deleteLoading(){
        datas.removeAt(datas.lastIndex) // 로딩이 완료되면 프로그레스바를 지움
    }
}