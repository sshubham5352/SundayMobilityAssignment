package com.example.sundaymobilityassignment.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sundaymobilityassignment.Constants
import com.example.sundaymobilityassignment.R
import com.example.sundaymobilityassignment.adapters.PlayerAdapter
import com.example.sundaymobilityassignment.databinding.ActivityPlayersBinding
import com.example.sundaymobilityassignment.models.Player
import java.util.*

class PlayersActivity : AppCompatActivity() {
    //class level fields
    private lateinit var binding: ActivityPlayersBinding
    private lateinit var playersList: List<Player>
    private val mAdapter = PlayerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_players)
        setSupportActionBar(binding.toolbar.root)

        //retrieving data from intent
        playersList = intent.getSerializableExtra(Constants.PLAYERS_ACTIVITY) as List<Player>

        binding.recyclerViewPlayers.apply {
            layoutManager = LinearLayoutManager(this@PlayersActivity)
            adapter = mAdapter
            mAdapter.submitList(playersList)
            setHasFixedSize(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_players_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_sort_by_first_name -> {
                mAdapter.sortByFirstName()
                true
            }
            R.id.action_sort_by_last_name -> {
                mAdapter.sortByLastName()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
