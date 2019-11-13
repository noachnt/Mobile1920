package com.github.noachnt.movietracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.noachnt.movietracker.database.Movie

class MovieItemAdapter (private val movieList: List<Movie>): RecyclerView.Adapter<MovieItemAdapter.MovieItemViewHolder>() {

    private lateinit var listener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieItemViewHolder(view, listener)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        val currentCardItem = movieList[position]

        holder.movieId.text = "(ID:${currentCardItem.movieId.toString()})"
        holder.movieName.text = currentCardItem.movieName
        holder.movieRating.text = currentCardItem.rating.toString() + " Star(s)"
    }

    class MovieItemViewHolder(itemView: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {

        var movieId: TextView = itemView.findViewById(R.id.movie_id)
        var movieName: TextView = itemView.findViewById(R.id.movie_name)
        var movieRating: TextView = itemView.findViewById(R.id.movie_rating)

        val iHaveToDoThisToExecuteTheFollowingFunction = itemView.setOnClickListener {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

}