package com.example.rickandmorty.presentation.ui.fragments.location

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty.data.model.Location
import com.example.rickandmorty.databinding.ItemLocationBinding

class LocationAdapter : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    private val list = ArrayList<Location>()

    fun setList(list: List<Location>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class LocationViewHolder(private val binding: ItemLocationBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(pos: Int) {
            binding.Locate.text = list[pos].name
            Glide.with(binding.image).load(list[pos].url).into(binding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder =
        LocationViewHolder(ItemLocationBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.onBind(position)
    }
}