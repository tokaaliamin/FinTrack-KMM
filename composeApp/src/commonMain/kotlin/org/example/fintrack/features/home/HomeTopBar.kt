package org.example.fintrack.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import fintrack_kmm.composeapp.generated.resources.Res
import fintrack_kmm.composeapp.generated.resources.ic_notification
import fintrack_kmm.composeapp.generated.resources.ic_profile
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeTopBar(name: String, modifier: Modifier = Modifier) {
    Row(
        modifier.fillMaxWidth().statusBarsPadding().navigationBarsPadding()
            .padding(16.dp),
    ) {
        Column(
            Modifier.weight(1f)
        ) {
            Text("Hello, $name", style = MaterialTheme.typography.labelLarge)
            Text(
                "Your financial journey starts here.",
                style = MaterialTheme.typography.labelSmall
            )
        }
        CircularIconButton(
            onClick = {},
            resource = Res.drawable.ic_profile,
        )
        CircularIconButton(
            onClick = {},
            resource = Res.drawable.ic_notification,
        )

    }
}

@Composable
fun CircularIconButton(
    onClick: () -> Unit,
    resource: DrawableResource,
    modifier: Modifier = Modifier
) {
    FilledIconButton(
        onClick = onClick,
        modifier = modifier,
        colors = IconButtonDefaults.filledIconButtonColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            contentColor = Color.Black
        )
    ) {
        Icon(
            painter = painterResource(resource),
            contentDescription = null,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeTopBarPreview() {
    MaterialTheme {
        HomeTopBar("Jane")
    }
}

@Preview(showBackground = true)
@Composable
fun CircularIconButtonPreview() {
    MaterialTheme {
        CircularIconButton({}, Res.drawable.ic_notification)
    }
}