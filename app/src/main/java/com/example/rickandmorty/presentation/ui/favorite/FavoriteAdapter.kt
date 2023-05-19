package com.example.rickandmorty.presentation.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty.data.model.Location
import com.example.rickandmorty.databinding.ItemListBinding
import com.example.rickandmorty.databinding.ItemLocationBinding

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private val list = arrayListOf<com.example.rickandmorty.data.model.Result>()

    fun setList(list: List<com.example.rickandmorty.data.model.Result>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class FavoriteViewHolder(private val binding: ItemListBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun onBind(position: Int) {
                binding.name.text = list[position].nameCharacter
                Glide.with(binding.image).load(list[position].imgUrl).into(binding.image)
                binding.gender.text = list[position].gender
                binding.status.text = list[position].statusLife
                binding.race.text = list[position].type
            }

    }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteViewHolder = FavoriteViewHolder(ItemListBinding
        .inflate(LayoutInflater.from(parent.context), parent,
            false)
    )


    override fun onBindViewHolder(holder: FavoriteAdapter.FavoriteViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int = list.size

}