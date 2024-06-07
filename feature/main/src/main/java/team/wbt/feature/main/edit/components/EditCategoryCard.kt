package team.wbt.feature.main.edit.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import team.wbt.feature.main.R
import team.wbt.feature.main.edit.model.Transaction

@Composable
internal fun EditCategoryCard(
    editType: Transaction,
    isSelected: Boolean = false,
    modifier: Modifier = Modifier,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = modifier
            .width(60.dp)
            .border(
                BorderStroke(
                    width = 1.dp,
                    color = if (isSelected) {
                        when (editType) {
                            is Transaction.Income -> {
                                Color.Cyan
                            }
                            is Transaction.Expense -> {
                                Color.Blue
                            }
                            else -> {
                                Color.White
                            }
                        }
                    } else Color.Gray
                ),
                shape = RoundedCornerShape(4.dp)
            )
            .padding(
                start = 12.dp,
                end = 12.dp,
                top = 8.dp,
                bottom = 8.dp
            )
            .clickable {

            }
    ) {
        Text(
            text = stringResource(
                id = when (editType) {
                    is Transaction.Income -> {
                        R.string.EDIT_TYPE_INCOME
                    }
                    is Transaction.Expense -> {
                        R.string.EDIT_TYPE_EXPENSE
                    }
                    is Transaction.Transfer-> {
                        R.string.EDIT_TYPE_TRANSFER
                    }
                }
            ),
            textAlign = TextAlign.Center,
            color = if (isSelected) {
                when (editType) {
                    is Transaction.Income -> {
                        Color.Cyan
                    }
                    is Transaction.Expense -> {
                        Color.Blue
                    }
                    else -> {
                        Color.White
                    }
                }
            } else Color.Gray
        )
    }
}