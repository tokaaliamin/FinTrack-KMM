package org.example.fintrack.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.example.fintrack.features.home.HomeScreen

@Composable
fun AppRoot() {
    Navigator(HomeScreen) { navigator ->
        SlideTransition(navigator) // nice animated transitions
    }
}