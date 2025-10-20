package org.example.fintrack.features.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

object HomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val scrollState = rememberScrollState()

        Scaffold(topBar = {
            HomeTopBar("Jane")
        }) { innerPadding ->
            CarouselCards(
                Modifier.padding(
                    innerPadding
                )
            )
        }

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CarouselCards(modifier: Modifier) {

        val carouselItems = remember {
            listOf(
                HomeCardType.AccountBalance,
                HomeCardType.TotalSavings,
                HomeCardType.MonthlyBudget,
                HomeCardType.TotalExpenses,
            )
        }

        HorizontalUncontainedCarousel(
            state = rememberCarouselState { carouselItems.count() },
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            itemWidth = 358.dp,
            itemSpacing = 16.dp,
        ) { i ->
            val item = carouselItems[i]
            HomeProgressCard(item, modifier = Modifier.padding(vertical = 8.dp))

        }
    }
}