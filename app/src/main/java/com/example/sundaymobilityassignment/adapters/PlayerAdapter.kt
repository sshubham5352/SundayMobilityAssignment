package com.example.sundaymobilityassignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sundaymobilityassignment.databinding.PlayerItemBinding
import com.example.sundaymobilityassignment.models.Player
import java.util.*

class PlayerAdapter :
    ListAdapter<Player, PlayerAdapter.ViewHolder>(PlayersDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PlayerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun sortByFirstName() {
        submitList(currentList.sortedBy { it.name.toLowerCase(Locale.ROOT) })
    }

    fun sortByLastName() {
        submitList(currentList.sortedBy { it.lastName })
    }

    class ViewHolder(private val binding: PlayerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(player: Player) {
            binding.apply {
                playerName.text = player.name.ifEmpty { "N/A" }
                if (player.captain)
                    captainTag.visibility = View.VISIBLE
                else
                    captainTag.visibility = View.GONE
            }
        }
    }

    class PlayersDiffCallback : DiffUtil.ItemCallback<Player>() {
        override fun areItemsTheSame(oldItem: Player, newItem: Player) = oldItem === newItem

        override fun areContentsTheSame(oldItem: Player, newItem: Player) = oldItem == newItem

    }
}
