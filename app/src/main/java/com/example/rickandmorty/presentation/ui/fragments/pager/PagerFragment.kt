package com.example.rickandmorty.presentation.ui.fragments.pager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.databinding.FragmentPagerBinding
import com.google.android.material.tabs.TabLayoutMediator


class PagerFragment : BaseFragment<FragmentPagerBinding>(FragmentPagerBinding::inflate) {


    override fun setupUI() {
        binding.view3.adapter = PagerAdapter(this)
        val list = listOf(
            "Characters",
            "Episodes",
            "Locations"
        )

        TabLayoutMediator(binding.tablayout, binding.view3) { tab, pos ->
            tab.text = list[pos]
        }.attach()
    }

    override fun setupObserver() {
    }


}