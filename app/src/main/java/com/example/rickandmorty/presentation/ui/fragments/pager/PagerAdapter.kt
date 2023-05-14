package com.example.rickandmorty.presentation.ui.fragments.pager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.rickandmorty.databinding.FragmentPagerBinding
import com.example.rickandmorty.presentation.ui.fragments.character.CharacterFragment
import com.example.rickandmorty.presentation.ui.fragments.episode.EpisodeAdapter
import com.example.rickandmorty.presentation.ui.fragments.episode.EpisodeFragment
import com.example.rickandmorty.presentation.ui.fragments.location.LocationFragment

class PagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> CharacterFragment()
            1 -> EpisodeFragment()
            2 -> LocationFragment()
            else -> CharacterFragment()
        }
    }


}