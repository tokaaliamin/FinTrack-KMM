package org.example.fintrack.features.accountSetup

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.example.fintrack.components.AppButton
import org.example.fintrack.components.AppToolbar
import org.example.fintrack.ui.theme.Neutral50

@Composable
fun CreatePassCodeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier,
        topBar = { AppToolbar(text = "Create your passcode", onBackClick = {}) },
        bottomBar = {
            AppButton(
                "Create a Pin",
                onClick = {},
                modifier = Modifier.navigationBarsPadding().padding(bottom = 24.dp)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "For a more secure and convenient way to view your account, create a 4-digit passcode now.",
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Center
            )
            Spacer(modifier.height(56.dp))
            Pin()
        }
    }
}

@Composable
fun Pin() {
    var selectedIndex by remember { mutableStateOf(0) }
    val numberOfDigits = 4
    val pinDigits: MutableList<Int?> = MutableList(4) { null }
    val pinDigitsFocus = List(numberOfDigits) { FocusRequester() }

    LaunchedEffect(Unit) {
        pinDigitsFocus[0].requestFocus()
    }

    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        repeat(numberOfDigits) { index ->
            PinDigit(
                focusRequester = pinDigitsFocus[index],
                hasNext = selectedIndex < numberOfDigits - 1,
                goToPreviousAction = {
                    if (selectedIndex > 0) {
                        pinDigits[selectedIndex] = null
                        pinDigitsFocus[selectedIndex.dec()].requestFocus()
                    }
                },
                goToNextAction = { newDigit ->
                    pinDigits[index] = newDigit
                    if (selectedIndex < numberOfDigits - 1) {
                        pinDigitsFocus[selectedIndex.inc()].requestFocus()
                    }
                },
                onFocusedAction = {
                    selectedIndex = index
                }, Modifier.weight(1f)
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PinDigit(
    focusRequester: FocusRequester,
    hasNext: Boolean = true,
    goToPreviousAction: () -> Unit,
    goToNextAction: (digit: Int?) -> Unit,
    onFocusedAction: () -> Unit,
    modifier: Modifier
) {
    var digit by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }

    BasicTextField(
        modifier = modifier
            .height(72.dp)
            .widthIn(max = 72.dp)
            .focusRequester(focusRequester)
            .onFocusChanged { state ->
                if (state.isFocused) onFocusedAction()
            }
            .onKeyEvent { keyEvent ->
                if (keyEvent.key == Key.Backspace && digit.isEmpty()) {
                    goToPreviousAction()
                    true
                } else {
                    false
                }
            },
        value = digit,
        onValueChange = { newValue ->
            if (newValue.isEmpty()) {
                digit = newValue
                goToPreviousAction()
            } else if (newValue.length == 1 && newValue.all { it.isDigit() }) {
                digit = newValue
                goToNextAction(digit.toIntOrNull())
            }
        },
        textStyle = MaterialTheme.typography.titleLarge.copy(
            color = Neutral50,
            textAlign = TextAlign.Center
        ),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = if (hasNext) ImeAction.Next else ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onNext = { goToNextAction(null) },
            onDone = { focusManager.clearFocus() }
        ),
        decorationBox = { innerTextField ->
            OutlinedTextFieldDefaults.DecorationBox(
                value = digit,
                innerTextField = innerTextField,
                enabled = true,
                singleLine = true,
                visualTransformation = VisualTransformation.None,
                interactionSource = interactionSource,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                    errorBorderColor = MaterialTheme.colorScheme.error,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                contentPadding = PaddingValues(0.dp),
            )
        }
    )
}