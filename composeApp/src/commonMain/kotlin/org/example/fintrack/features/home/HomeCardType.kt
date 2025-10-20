package org.example.fintrack.features.home

import androidx.compose.ui.graphics.Color
import fintrack_kmm.composeapp.generated.resources.Res
import fintrack_kmm.composeapp.generated.resources.bg_account_balance
import fintrack_kmm.composeapp.generated.resources.bg_budget
import fintrack_kmm.composeapp.generated.resources.bg_expenses
import fintrack_kmm.composeapp.generated.resources.bg_savings
import org.example.fintrack.ui.theme.LightGreen
import org.example.fintrack.ui.theme.LightOrange
import org.example.fintrack.ui.theme.Orange
import org.example.fintrack.ui.theme.Primary40
import org.jetbrains.compose.resources.DrawableResource

sealed class HomeCardType(
    val title: String,
    val actionButtonLabel: String,
    val actionButtonLabelBackgroundColor: Color,
    val actionButtonLabelTextColor: Color,
    val backgroundColor: Color,
    val backgroundImage: DrawableResource,
    val textColor: Color,
    val subtitle: String,
    val visibilityIconColor: Color,
    val hasProgressBar: Boolean,
    val progressbarColor: Color? = null
) {
    data object AccountBalance : HomeCardType(
        title = "Account balance",
        actionButtonLabel = "Link bank accounts",
        backgroundColor = Primary40,
        backgroundImage = Res.drawable.bg_account_balance,
        subtitle = "The total balance from your linked accounts.",
        hasProgressBar = false, actionButtonLabelBackgroundColor = Color.White,
        actionButtonLabelTextColor = Primary40,
        textColor = Color.White,
        visibilityIconColor = LightGreen
    )

    data object TotalSavings : HomeCardType(
        title = "Total savings",
        actionButtonLabel = "Add a savings goal",
        backgroundColor = Orange,
        backgroundImage = Res.drawable.bg_savings,
        subtitle = "You haven’t created any savings goals yet",
        hasProgressBar = true,
        actionButtonLabelBackgroundColor = Color.White,
        actionButtonLabelTextColor = Orange,
        textColor = Color.White,
        visibilityIconColor = LightOrange,
        progressbarColor = Color.White
    )

    data object MonthlyBudget : HomeCardType(
        title = "Monthly budget",
        actionButtonLabel = "Create a Budget",
        backgroundColor = Color.White,
        backgroundImage = Res.drawable.bg_budget,
        subtitle = "You haven’t created any budgets yet",
        hasProgressBar = true,
        actionButtonLabelBackgroundColor = Primary40,
        actionButtonLabelTextColor = Color.White,
        textColor = Color.Black,
        visibilityIconColor = Primary40,
        progressbarColor = Orange
    )

    data object TotalExpenses : HomeCardType(
        title = "Total expenses",
        actionButtonLabel = "Link bank accounts",
        backgroundColor = LightOrange,
        backgroundImage = Res.drawable.bg_expenses,
        subtitle = "You haven’t linked any bank account yet",
        hasProgressBar = true,
        actionButtonLabelBackgroundColor = Primary40,
        actionButtonLabelTextColor = Color.White,
        textColor = Color.Black,
        visibilityIconColor = Primary40,
        progressbarColor = Orange
    )
}