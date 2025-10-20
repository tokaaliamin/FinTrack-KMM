package org.example.fintrack.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paleblueapps.kmpcore.formatters.currency.CurrencyFormatter
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeProgressCard(type: HomeCardType, modifier: Modifier = Modifier) {

    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = type.backgroundColor,
            contentColor = type.textColor
        ),
    ) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
            Image(
                painter = painterResource(type.backgroundImage),
                contentDescription = null,
                modifier = Modifier.align(Alignment.BottomEnd)
            )

            Column(
                Modifier.padding(top = 16.dp, bottom = 24.dp, start = 16.dp, end = 10.dp).align(
                    Alignment.TopCenter
                )
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        type.title,
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.weight(1f)
                    )
                    Row(
                        modifier = Modifier.clickable {}.background(
                            color = type.actionButtonLabelBackgroundColor,
                            shape = RoundedCornerShape(12.dp)
                        ).padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            type.actionButtonLabel,
                            style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
                            color = type.actionButtonLabelTextColor
                        )
                        Spacer(Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowForwardIos,
                            contentDescription = null,
                            tint = type.actionButtonLabelTextColor,
                            modifier = Modifier.height(10.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                MoneyWithCurrency(type.visibilityIconColor)
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    type.subtitle,
                    style = MaterialTheme.typography.labelSmall,
                )
                Spacer(modifier = Modifier.height(24.dp))
                if (type.hasProgressBar && type.progressbarColor != null)
                    LinearProgressIndicator(
                        progress = { 0.75f },
                        color = type.progressbarColor,
                        trackColor = type.progressbarColor.copy(alpha = 0.3f),
                        modifier = modifier.fillMaxWidth(),
                        strokeCap = StrokeCap.Round,
                        gapSize = 0.dp,
                    )
            }

        }
    }

}

@Composable
fun MoneyWithCurrency(visibilityIconColor: Color) {
    //Unfortunately I found out too late that this library deosn't seem to support NGN nor EGP. will try to find a replacement later or even contribute
    val currencyFormatter = CurrencyFormatter()

    val formattedAmount = currencyFormatter.format(
        amount = 1000500.55,
        currencyCode = "EUR",
        withCurrencySymbol = true,
        minimumFractionDigits = 2,
        maximumFractionDigits = 2
    )
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(formattedAmount, style = MaterialTheme.typography.titleSmall)
        Icon(
            imageVector = Icons.Default.Visibility,
            contentDescription = null,
            tint = visibilityIconColor,
            modifier = Modifier.size(20.dp)
        )
    }

}


@Preview(showBackground = true)
@Composable
fun AccountProgressCardPreview() {
    MaterialTheme {
        HomeProgressCard(HomeCardType.AccountBalance)
    }
}

@Preview(showBackground = true)
@Composable
fun TotalSavingsProgressCardPreview() {
    MaterialTheme {
        HomeProgressCard(HomeCardType.TotalSavings)
    }
}