package com.github.noachnt.movietracker.moviedetails
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.noachnt.movietracker.database.Movie
import com.github.noachnt.movietracker.MainActivity
import com.github.noachnt.movietracker.database.MovieDatabaseDao
import com.github.noachnt.movietracker.movietracker.MovieTrackerFragment
import kotlinx.coroutines.*

class MovieDetailsViewModel (
    private val movieKey: Long = 0L,
    val database: MovieDatabaseDao) : ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _navigateToMovieTracker = MutableLiveData<String?>()
    val navigateToMovieTracker: LiveData<String?>
        get() = _navigateToMovieTracker

    fun doneNavigating() {
        _navigateToMovieTracker.value = null
    }

    fun onSubmitMovie (movieName: EditText, review: EditText, rating: RatingBar) {
        when {
            movieName.text.toString() == "" -> _navigateToMovieTracker.value = "emptyMovieName"
            rating.rating.toInt() == 0 -> _navigateToMovieTracker.value = "emptyRating"
            review.text.toString() == "" -> _navigateToMovieTracker.value = "emptyReview"
            else -> {
                uiScope.launch {
                    withContext(Dispatchers.IO) {
                        val newMovie = Movie()
                        newMovie.movieName = movieName.text.toString()
                        newMovie.rating = rating.rating.toInt()
                        newMovie.review = review.text.toString()
                        database.insert(newMovie)
                    }
                    _navigateToMovieTracker.value = "clear"
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}