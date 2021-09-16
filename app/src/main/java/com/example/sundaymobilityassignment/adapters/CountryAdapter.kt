package com.example.sundaymobilityassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sundaymobilityassignment.databinding.CountryItemBinding

class CountryAdapter(
    private val mList: List<String>,
    private val mListener: OnCountryItemClickListener
) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CountryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.countryName.text = mList[position]
    }

    override fun getItemCount() = mList.size


    inner class ViewHolder(binding: CountryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val countryName = binding.countryName

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION)
                    mListener.onItemClick(position)
            }
        }
    }

    interface OnCountryItemClickListener {
        fun onItemClick(position: Int)
    }
}