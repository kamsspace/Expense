package com.kamsspace.expense

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RecentExpensesGrid() {
    Column {
        Row {
            ExpenseItemCard(name = "Potato", amount = "1kg", modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.size(8.dp))
            ExpenseItemCard(name = "Milk", amount = "2L", modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.size(8.dp))
        Row {
            ExpenseItemCard(name = "Tomato", amount = "3kg", modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.size(8.dp))
            ExpenseItemCard(name = "Bread", amount = "1pc", modifier = Modifier.weight(1f))
        }
    }
}