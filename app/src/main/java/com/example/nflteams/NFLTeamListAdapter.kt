package com.example.nflteams

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.nflteams.databinding.ListItemTeamBinding

interface OnTeamClickListener {
    fun onTeamClick(nflteam: NFLTeam)
}
class NFLTeamHolder(
    private val binding: ListItemTeamBinding,
    private val clickListener: OnTeamClickListener
) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    private lateinit var nflteam: NFLTeam
    init {
        binding.root.setOnClickListener(this)
    }
    fun bind(nflteam: NFLTeam) {
        this.nflteam = nflteam
        binding.teamName.text = nflteam.teamName
        binding.stadiumName.text = nflteam.stadium
        val resourceId = binding.root.resources.getIdentifier(nflteam.logoFile.substringBefore("."),"drawable",binding.root.context.packageName)
        binding.teamLogo.setImageResource(resourceId)
        binding.root.setOnClickListener {
            clickListener.onTeamClick(nflteam)
        }
    }

    override fun onClick(v: View) {
        clickListener.onTeamClick(nflteam)
    }
}

class NFLTeamListAdapter(
    private val nflteams: List<NFLTeam>,
    private val clickListener: OnTeamClickListener
) : RecyclerView.Adapter<NFLTeamHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) : NFLTeamHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemTeamBinding.inflate(inflater, parent, false)
        return NFLTeamHolder(binding, clickListener)
    }
    override fun onBindViewHolder(holder: NFLTeamHolder, position: Int) {
        val nflteam = nflteams[position]
        holder.bind(nflteam)
    }
    override fun getItemCount() = nflteams.size
}