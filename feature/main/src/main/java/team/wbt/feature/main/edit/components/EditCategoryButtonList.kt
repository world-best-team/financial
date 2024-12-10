package team.wbt.feature.main.edit.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import team.wbt.feature.main.edit.model.Transaction

@Composable
fun EditCategoryButtonList(
    modifier: Modifier = Modifier,
    currentType: Transaction,
    onClick: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        EditCategoryCard(
            editType = Transaction.Income,
            isSelected = currentType is Transaction.Income
        )
        EditCategoryCard(
            editType = Transaction.Transfer,
            isSelected = currentType is Transaction.Transfer
        )
        EditCategoryCard(
            editType = Transaction.Expense(),
            isSelected = currentType is Transaction.Expense
        )
    }
}