// MovieDetailsActivity.kt
package com.example.and_app_flixster_part2




import android.graphics.Movie
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.flixster_v2_android_app.R
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val movie = intent.getParcelableExtra<Movie>("movie")

        tvTitle.text = movie?.title
        tvOverview.text = movie?.overview
        Glide.with(this).load("https://image.tmdb.org/t/p/w500/${movie?.posterPath}").into(imgPoster)

        // Display additional details as needed
    }
}
