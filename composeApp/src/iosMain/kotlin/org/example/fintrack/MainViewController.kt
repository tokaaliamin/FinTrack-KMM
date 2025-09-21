package org.example.fintrack

import androidx.compose.ui.window.ComposeUIViewController
import org.example.fintrack.ui.theme.AppTheme

fun MainViewController() = ComposeUIViewController { AppTheme { App() } }