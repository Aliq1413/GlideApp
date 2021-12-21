package com.example.glideapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.glideapp.databinding.ItemRowBinding

class RVAdapter(private val activity: MainActivity, private val photos: ArrayList<FeedImage>): RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder(val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val photo = photos[position]
        holder.binding.apply {
            tvName.text = photo.title
            Glide.with(activity).load(photo.link).into(image)
            main.setOnClickListener { activity.viewImg(photo.link) }
        }
    }

    override fun getItemCount() = photos.size
}