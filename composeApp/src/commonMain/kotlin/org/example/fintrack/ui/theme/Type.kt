package org.example.fintrack.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import fintrack_kmm.composeapp.generated.resources.Capriola
import fintrack_kmm.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun Type(): androidx.compose.material3.Typography {
    val myFontFamily = FontFamily(
        Font(Res.font.Capriola, FontWeight.Normal),
        Font(Res.font.Capriola, FontWeight.Bold),
    )

    return with(MaterialTheme.typography) {
        copy(
            titleLarge = titleLarge.copy(
                fontFamily = myFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 40.sp,
                lineHeight = 1.5.em
            ),
            titleSmall = titleSmall.copy(
                fontFamily = myFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                lineHeight = 1.5.em
            ),
            labelLarge = labelLarge.copy(
                fontFamily = myFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            ),
            labelMedium = labelMedium.copy(
                fontFamily = myFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 1.5.em
            ),
            labelSmall = labelSmall.copy(
                fontFamily = myFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            ),
            bodyLarge = bodyLarge.copy(fontFamily = myFontFamily, fontWeight = FontWeight.Normal),
            bodyMedium = bodyMedium.copy(fontFamily = myFontFamily, fontWeight = FontWeight.Normal),
            bodySmall = bodySmall.copy(fontFamily = myFontFamily, fontWeight = FontWeight.Normal),
        )
    }
}
