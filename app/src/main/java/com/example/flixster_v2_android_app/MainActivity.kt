// MainActivity.kt
package com.example.and_app_flixster_part2

// MainActivity.kt


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import org.json.JSONException

class MainActivity : AppCompatActivity(), MovieAdapter.OnItemClickListener {

    private lateinit var rvMovies: RecyclerView
    private lateinit var adapter: MovieAdapter
    private var movies: MutableList<Movie> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        rvMovies = findViewById(R.id.rvMovies)
        adapter = MovieAdapter(this, movies, this)
        rvMovies.adapter = adapter
        rvMovies.layoutManager = LinearLayoutManager(this)

        val client = AsyncHttpClient()
        val movieUrl = "https://api.themoviedb.org/3/movie/top_rated?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed"

        client.get(movieUrl, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON) {
                try {
                    val movieJsonArray = json.jsonObject.getJSONArray("results")
                    movies.addAll(Movie.fromJsonArray(movieJsonArray))
                    adapter.notifyDataSetChanged()
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }

            override fun onFailure(statusCode: Int, headers: Headers?, response: String, throwable: Throwable?) {
                // Handle the failure
            }
        })
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra("movie", movies[position])
        startActivity(intent)
    }
}
