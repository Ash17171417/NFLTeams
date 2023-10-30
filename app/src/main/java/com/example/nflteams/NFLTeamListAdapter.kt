package com.example.nflteams

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.nflteams.databinding.ListItemTeamBinding

class NFLTeamHolder(
    private val binding: ListItemTeamBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(nflteam: NFLTeam) {
        binding.teamName.text = nflteam.teamName
        binding.stadiumName.text = nflteam.stadium.toString()
        val resourceId = binding.root.resources.getIdentifier(nflteam.logoFile.substringBefore("."),"drawable",binding.root.context.packageName)
        binding.teamLogo.setImageResource(resourceId)
        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${nflteam.teamName} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

class NFLTeamListAdapter(
    private val nflteams: List<NFLTeam>
) : RecyclerView.Adapter<NFLTeamHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) : NFLTeamHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemTeamBinding.inflate(inflater, parent, false)
        return NFLTeamHolder(binding)
    }
    override fun onBindViewHolder(holder: NFLTeamHolder, position: Int) {
        val nflteam = nflteams[position]
        holder.bind(nflteam)
    }
    override fun getItemCount() = nflteams.size
}