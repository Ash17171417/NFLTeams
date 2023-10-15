package com.example.nflteams

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nflteams.databinding.FragmentTeamListBinding

private const val TAG = "NFLTeamListFragment"

class NFLTeamListFragment : Fragment() {

    private var _binding: FragmentTeamListBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }


    private val NFLTeamListViewModel: NFLTeamListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total Teams: $(NFLTeamsListViewModel.NFLTeams.size")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTeamListBinding.inflate(inflater, container, false)

        binding.teamRecyclerView.layoutManager = LinearLayoutManager(context)

        val NFLTeams = NFLTeamListViewModel.teams
        val adapter = NFLTeamListAdapter(NFLTeams)
        binding.teamRecyclerView.adapter = adapter

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}