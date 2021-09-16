package com.example.sundaymobilityassignment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sundaymobilityassignment.activities.PlayersActivity
import com.example.sundaymobilityassignment.adapters.CountryAdapter
import com.example.sundaymobilityassignment.apiservices.ApiManager
import com.example.sundaymobilityassignment.apiservices.ApiResponse
import com.example.sundaymobilityassignment.databinding.ActivityMainBinding
import com.example.sundaymobilityassignment.models.Countries
import com.example.sundaymobilityassignment.models.Player
import java.io.Serializable

class MainActivity : AppCompatActivity(), ApiResponse, CountryAdapter.OnCountryItemClickListener {
    //class level fields
    private val apiManager by lazy {
        ApiManager(this)
    }
    private val countryNames by lazy {
        resources.getStringArray(R.array.countries).toList().sortedBy { it }
    }
    private var playersResponse: Countries? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil
            .setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar.root)

        //setting recyclerView
        binding.recyclerViewCountries.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = CountryAdapter(countryNames, this@MainActivity)
            setHasFixedSize(true)
        }
        //fetching data
        apiManager.getPlayers()
    }

    override fun onCallResponse(response: Any) {
        playersResponse = response as Countries
    }

    override fun onCallFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        Log.d(Constants.MAIN_ACTIVITY, "onCallFailure $message")
    }

    //onRecyclerViewItemCLick
    override fun onItemClick(position: Int) {
        val players = when (position) {
            0 -> playersResponse?.afghanistan
            1 -> playersResponse?.australia
            2 -> playersResponse?.bangladesh
            3 -> playersResponse?.england
            4 -> playersResponse?.india
            5 -> playersResponse?.newZealand
            6 -> playersResponse?.pakistan
            7 -> playersResponse?.southAfrica
            8 -> playersResponse?.sriLanka
            9 -> playersResponse?.westIndies
            else -> null
        }
        startPlayersActivity(players)
    }

    private fun startPlayersActivity(players: List<Player>?) {
        val intent = Intent(this, PlayersActivity::class.java)
        intent.putExtra(Constants.PLAYERS_ACTIVITY, players as Serializable)
        startActivity(intent)
    }
}
