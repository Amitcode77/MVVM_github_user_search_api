package com.example.mvvm_github_user_search.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_github_user_search.R
import com.example.mvvm_github_user_search.data.model.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(val data: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemView.apply {
            tv_username.text = data[position].login
            Picasso.get().load(data[position].avatar_url).into(iv_user_icon)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}