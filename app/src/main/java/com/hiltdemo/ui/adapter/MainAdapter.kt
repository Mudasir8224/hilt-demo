package com.hiltdemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hiltdemo.R
import com.hiltdemo.data.model.User
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton

@ActivityScoped
class MainAdapter @Inject constructor(
    private val users: ArrayList<User>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewUserName: TextView
        var textViewUserEmail: TextView
        var imageViewAvatar: ImageView

        init {
            textViewUserName = itemView.findViewById(R.id.textViewUserName)
            textViewUserEmail = itemView.findViewById(R.id.textViewUserEmail)
            imageViewAvatar = itemView.findViewById(R.id.imageViewAvatar)
        }

        fun bind(user: User) {
            textViewUserName.text = user.name
            textViewUserEmail.text = user.email
            Glide.with(imageViewAvatar.context)
                .load(user.avatar)
                .into(imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(users[position])

    fun addData(list: List<User>) {
        users.addAll(list)
    }
}