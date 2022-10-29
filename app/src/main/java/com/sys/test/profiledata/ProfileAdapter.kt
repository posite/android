package com.sys.test.profiledata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sys.test.R

class ProfileAdapter(private val datas : ArrayList<ProfileData>) : RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {

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

        fun bind(item: ProfileData) {
            txtTitle.text = item.title
            txtAddress.text = item.roadaddress
            Glide.with(itemView).load(item.thumbnailpath).into(imgProfile)

        }
    }


}