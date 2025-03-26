package com.example.anipal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimeAdapter(private val animeList: List<AnimeModel>) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    inner class AnimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.anime_title)
        val image: ImageView = view.findViewById(R.id.anime_image)
        val rating: TextView = view.findViewById(R.id.rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.anime_tile, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val anime = animeList[position]
        holder.title.text = anime.title
        holder.image.setImageResource(anime.imageResId)
        holder.rating.text = anime.rating
    }

    override fun getItemCount() = animeList.size
}
