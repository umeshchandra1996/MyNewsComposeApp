package com.example.myfirstcomposeapp.dashboard


import com.example.myfirstcomposeapp.R

sealed class NavigationItems(var route:String,var Drawable: Int,var Title:String){
    object Home : NavigationItems("home", R.drawable.ic_home, "Home")
    object Music : NavigationItems("music", R.drawable.ic_music, "Music")
    object Movies : NavigationItems("movies", R.drawable.ic_movie, "Movies")
    object Books : NavigationItems("books", R.drawable.ic_book, "Books")
    object Profile : NavigationItems("profile", R.drawable.ic_profile, "Profile")
}

