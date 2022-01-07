package com.complexdesign.ui.bottombar

import com.complexdesign.R
//Screens
sealed class BottomBarScreen(
    val title: String,
    val route: String,
    val iconId: Int
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        iconId = R.drawable.ic_home
    )
    object Meditate : BottomBarScreen(
        route = "meditate",
        title = "Meditate",
        iconId = R.drawable.ic_bubble
    )
    object Sleep : BottomBarScreen(
        route = "sleep",
        title = "Sleep",
        iconId = R.drawable.ic_moon
    )
    object Music : BottomBarScreen(
        route = "music",
        title = "Music",
        iconId = R.drawable.ic_music
    )
    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        iconId = R.drawable.ic_profile
    )

}
