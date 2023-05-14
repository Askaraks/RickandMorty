package com.example.rickandmorty.presentation.ui.fragments.episode

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty.data.model.Episode
import com.example.rickandmorty.data.model.Location
import com.example.rickandmorty.databinding.ItemEpisodeBinding
import com.example.rickandmorty.databinding.ItemLocationBinding

class EpisodeAdapter : RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    private val list = ArrayList<Episode>()

    fun setList(list: List<Episode>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class EpisodeViewHolder(private val binding: ItemEpisodeBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(pos: Int) {
            binding.episode.text = list[pos].episode
            binding.name3.text = list[pos].name
            binding.data.text = list[pos].airDate

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder =
        EpisodeViewHolder(
            ItemEpisodeBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.onBind(position)
    }
}