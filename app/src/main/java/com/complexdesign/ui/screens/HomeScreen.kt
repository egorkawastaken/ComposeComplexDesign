package com.complexdesign.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import com.complexdesign.R
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.complexdesign.AddItem
import com.complexdesign.ui.bottombar.BottomBarScreen
import com.complexdesign.ui.bottombar.BottomNavGraph
import com.complexdesign.ui.theme.*

@ExperimentalFoundationApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        backgroundColor = MaterialTheme.colors.surface,
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            BottomNavGraph(navHostController = navController)
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun HomeScreen() {
        Column(

        ) {
            TextAndIcon(name = "Aboba")
            Chips(
                chips = listOf(
                    "Sweet sleep",
                    "Insomnia",
                    "Depression",
                    "Filler",
                    "Filler",
                    "Filler",
                    "Filler",
                    "Filler",
                    "Filler",
                    "Filler"
                )
            )
            CurrentMeditation()
            Features(
                features = listOf(
                    Feature(
                        title = "Sleep meditation",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night island",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    )
                )
            )

        }


}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile,
        BottomBarScreen.Meditate,
        BottomBarScreen.Music,
        BottomBarScreen.Sleep
    )
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination
    
    BottomNavigation(
        
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }

}



@Composable
fun TextAndIcon(name: String = "Name") {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good Morning, $name!",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.body1
            )
        }
        IconButton(
            modifier = Modifier
                .size(48.dp),
            onClick = { /*TODO*/ }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
            )
        }
    }
}

@Composable
fun Chips(chips: List<String>) {

    var selectedItem by remember { mutableStateOf(0) }

    LazyRow {
        items(chips.size) {
            Chip(
                content = chips[it],
                onSelectItem = { selectedItem = it },
                isSelected = (selectedItem == it)
            )
        }
    }
}

@Composable
fun Chip(
    content: String,
    onSelectItem: () -> Unit,
    isSelected: Boolean
) {

    val background by animateColorAsState(targetValue = if (isSelected) ButtonBlue else DarkerButtonBlue)
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
            .clickable {
                onSelectItem()
            }
            .clip(RoundedCornerShape(8.dp))
            .background(
                color = background
            )
            .padding(16.dp)
    ) {
        Text(
            text = content,
            color = TextWhite
        )
    }
}

@Composable
fun CurrentMeditation(
    color: Color = LightRed
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "Meditation • 3-10 min",
                style = MaterialTheme.typography.body1,
                color = TextWhite
            )
        }
        IconButton(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(start = 4.dp),
            onClick = { /*TODO*/ }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "play",
                tint = Color.White,
                modifier = Modifier
                    .size(16.dp)
            )
        }

    }
}

