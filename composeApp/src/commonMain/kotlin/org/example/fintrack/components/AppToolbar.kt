package org.example.fintrack.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fintrack_kmm.composeapp.generated.resources.Res
import fintrack_kmm.composeapp.generated.resources.ic_back_button
import org.jetbrains.compose.resources.painterResource

@Composable
fun AppToolbar(text: String, onBackClick: () -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier.statusBarsPadding().navigationBarsPadding().fillMaxWidth().padding(top = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            painter = painterResource(Res.drawable.ic_back_button),
            contentDescription = null,
            modifier = modifier.clickable(onClick = onBackClick)
                .padding(vertical = 12.dp)
                .weight(1f)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
        )
        Spacer(modifier = modifier.size(24.dp).weight(1f))
    }
}