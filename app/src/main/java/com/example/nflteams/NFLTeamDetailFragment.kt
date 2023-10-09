package com.example.nflteams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nflteams.databinding.FragmentTeamDetailBinding

class NFLTeamDetailFragment: Fragment() {

    private lateinit var binding: FragmentTeamDetailBinding

    private lateinit var nflteam: NFLTeam

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nflteam = NFLTeam(
            teamID = "1",
            teamName = "Indianapolis Colts",
            logoFile = "colts.png",
            conference = "",
            division = "AFC South",
            stadium = "Lucas Oil Stadium",
            latitude = 39.760056,
            longitude = -86.163806
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}