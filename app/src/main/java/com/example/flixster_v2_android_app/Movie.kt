<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
android:layout_width="match_parent"
android:layout_height="match_parent">
<!-- activity_movie_detail.xml -->
<ImageView
android:id="@+id/movieImage"
android:layout_width="match_parent"
android:layout_height="200dp"
android:scaleType="centerCrop"
android:src="@drawable/placeholder_poster"
android:layout_alignParentTop="true"
android:layout_centerHorizontal="true"/>

<TextView
android:id="@+id/movieTitle"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:layout_below="@id/movieImage"
android:padding="16dp"
android:textSize="24sp"
android:textColor="@color/black"
android:textStyle="bold"/>

<TextView
android:id="@+id/movieOverview"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:layout_below="@id/movieTitle"
android:padding="16dp"
android:textSize="16sp"/>

<!-- Add more TextViews or other views here for additional movie details -->
</RelativeLayout>
