package org.example.fintrack.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Primary40,
    onPrimary = Primary20,
    secondary = Secondary40,
    background = Background,
    onBackground = OnBackground,
)

private val DarkColors = darkColorScheme(
    primary = Primary80,
    onPrimary = Color.Black,
    secondary = Secondary80,
    background = Color(0xFF121212),
    onBackground = Color(0xFFEAEAEA),
)

@Composable
fun AppTheme(
    useDarkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (useDarkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Type(),
        content = content
    )
}
