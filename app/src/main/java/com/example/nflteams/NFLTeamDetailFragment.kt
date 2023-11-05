package com.example.nflteams

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.nflteams.databinding.FragmentTeamDetailBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

private const val TAG = "NFLTeamDetailFragment"
class NFLTeamDetailFragment: Fragment(), OnMapReadyCallback {

    private  var _binding: FragmentTeamDetailBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Unable to initialize binding. Is view created?"
        }

    private lateinit var nflteam: NFLTeam

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args: NFLTeamDetailFragmentArgs by navArgs()
        nflteam = args.nflteam

        Log.d(TAG, "Received NFLTeam: $nflteam")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.teamName.text = nflteam.teamName
        binding.stadiumName.text = nflteam.stadium
        binding.teamDivision.text = nflteam.division
        val resourceId = resources.getIdentifier(nflteam.logoFile.substringBefore("."), "drawable", requireContext().packageName)
        binding.teamLogo.setImageResource(resourceId)
        binding.mapview.getMapAsync(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTeamDetailBinding.inflate(layoutInflater, container, false)
        binding.mapview.onCreate(savedInstanceState)
        return binding.root
    }

    override fun onMapReady(p0: GoogleMap) {
        map = p0
        map.uiSettings.isZoomControlsEnabled = false
        map.uiSettings.isMyLocationButtonEnabled = false

        val team = LatLng(nflteam.latitude, nflteam.longitude)

        map.addMarker(MarkerOptions().position(team).visible(true))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(team,15f))
        binding.mapview.onResume()
    }
}