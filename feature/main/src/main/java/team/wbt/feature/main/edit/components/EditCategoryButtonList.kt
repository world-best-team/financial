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
            editType = CategoryType.INCOME,
            isSelected = currentType is Transaction.Income
        )
        EditCategoryCard(
            editType = CategoryType.EXPENSE,
            isSelected = currentType is Transaction.Expense
        )
        EditCategoryCard(
            editType = CategoryType.TRANSFER,
            isSelected = currentType is Transaction.Transfer
        )
    }
}