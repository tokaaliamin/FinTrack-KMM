package org.example.fintrack.features.accountSetup.getStarted

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import fintrack_kmm.composeapp.generated.resources.Res
import fintrack_kmm.composeapp.generated.resources.ic_create_savings_goal
import fintrack_kmm.composeapp.generated.resources.ic_link_bank_account
import fintrack_kmm.composeapp.generated.resources.ic_setup_pin

@Composable
fun GetStartedScreen(onSetUpPinClick: () -> Unit, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Scaffold(topBar = {
        TopTitle()
    }, bottomBar = {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(horizontal = 24.dp).padding(bottom = 24.dp),
            onClick = {}
        ) {
            Text("Skip for now", modifier = Modifier.padding(8.dp))
        }
    }) { innerPadding ->

        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            GettingStartedOptionCard(
                resource = Res.drawable.ic_setup_pin,
                title = "Set up a pin",
                subTitle = "Enhance your  account security.",
                onClick = onSetUpPinClick,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            GettingStartedOptionCard(
                resource = Res.drawable.ic_link_bank_account,
                title = "Link your bank accounts.",
                subTitle = "Link your bank accounts to start tracking your expenses.",
                onClick = {})

            Spacer(modifier = Modifier.height(24.dp))

            GettingStartedOptionCard(
                resource = Res.drawable.ic_create_savings_goal,
                title = "Create a savings goal",
                subTitle = "What are your financial goals?",
                onClick = {},
                modifier = Modifier.padding(bottom = 8.dp)
            )

        }
    }
}

@Composable
private fun TopTitle(modifier: Modifier = Modifier) {
    val styledText: AnnotatedString = buildAnnotatedString {
        append("Welcome to ")

        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            append("Fintrack")
        }

        append("!\nLet's get you set up.")
    }

    Text(
        text = styledText,
        style = MaterialTheme.typography.titleSmall,
        modifier = modifier.statusBarsPadding().navigationBarsPadding().padding(horizontal = 24.dp)
            .padding(top = 30.dp)
    )
}


