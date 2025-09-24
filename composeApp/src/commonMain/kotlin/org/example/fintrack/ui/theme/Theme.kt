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

    background = Neutral10,
    onBackground = Neutral900,

    surface = Neutral10,
    onSurface = Neutral900,

    surfaceVariant = Neutral25,
    onSurfaceVariant = Neutral700,

    outline = Neutral50
)

private val DarkColors = darkColorScheme(
    primary = Primary80,
    onPrimary = Color.Black,

    secondary = Secondary80,

    background = Neutral900,
    onBackground = Neutral10,

    surface = Neutral800,
    onSurface = Neutral10,

    surfaceVariant = Neutral700,
    onSurfaceVariant = Neutral25,

    outline = Neutral50
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
