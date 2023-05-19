package com.example.rickandmorty.presentation.ui.fragments.character

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.rickandmorty.data.model.Result
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.rickandmorty.databinding.ItemListBinding
import com.example.rickandmorty.presentation.ui.fragments.character.ext.loadImage

class CharacterAdapter(
    private val click : (id: Int) -> Unit,
    private val onLongClick: (model: Result) -> Unit
) : Adapter<CharacterAdapter.AdapterViewHolder>() {
    private val list = ArrayList<Result>()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Result>){
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AdapterViewHolder(
        ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CharacterAdapter.AdapterViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.itemView.setOnClickListener {
            click(list[position].id)
        }

        holder.itemView.setOnLongClickListener {
        onLongClick(list[position])
            true
        }
    }

    override fun getItemCount() = list.size


    class AdapterViewHolder(private val binding: ItemListBinding) : ViewHolder(binding.root) {

        fun onBind(result: Result) {
            result.imgUrl?.let { binding.image.loadImage(it) }
            binding.name.text = result.nameCharacter
            binding.race.text = result.type
            binding.gender.text = result.gender
            binding.status.text = result.statusLife
        }
    }
}
