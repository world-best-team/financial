package team.wbt.feature.main.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import team.wbt.feature.main.R
import team.wbt.feature.main.edit.components.CategoryType
import team.wbt.feature.main.edit.components.EditCategoryCard
import team.wbt.feature.main.edit.components.EditDetailOption
import team.wbt.feature.main.edit.components.EditItem
import team.wbt.feature.main.edit.components.EditToggleSwitch
import team.wbt.feature.main.edit.components.EditTopBar
import team.wbt.feature.main.edit.model.EditUiModel
import team.wbt.feature.main.edit.model.Transaction


private val BORDER_SIZE = 1.dp

@Composable
fun EditScreen() {
    Scaffold(
        topBar = {
            EditTopBar(
                modifier = Modifier
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .imePadding()
            .navigationBarsPadding()
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            EditTopDetail()
            Spacer(modifier = Modifier.height(10.dp))
            EditListScreen()
        }
    }
}

@Composable
private fun EditTopDetail(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "라온 약국",
            fontSize = 18.sp
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "10000원",
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp
            )
            Spacer(modifier = Modifier.padding(2.dp))
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    modifier = Modifier.size(24.dp),
                    contentDescription = null
                )
            }
        }
        Text(
            text = "명세서 | 인식금액 10,000원",
            textDecoration = TextDecoration.Underline,
            color = Color.Gray.copy(alpha = 0.5f)
        )
    }
}

@Composable
private fun EditListScreen(
    modifier: Modifier = Modifier,
    editItem: EditUiModel = EditUiModel(),
) {
    Column(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
    ) {
        EditItem(
            title = stringResource(id = R.string.EDIT_TYPE),
            content = {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    EditCategoryCard(
                        editType = CategoryType.INCOME,
                        isSelected = editItem.type is Transaction.Income
                    )
                    EditCategoryCard(
                        editType = CategoryType.EXPENSE,
                        isSelected = editItem.type is Transaction.Expense
                    )
                    EditCategoryCard(
                        editType = CategoryType.TRANSFER,
                        isSelected = editItem.type is Transaction.Transfer
                    )
                }
            }
        )
        Spacer(
            modifier = Modifier
                .height(BORDER_SIZE)
                .fillMaxWidth()
                .background(color = Color.Gray.copy(alpha = 0.8f))
        )
        EditItem(
            title = stringResource(id = R.string.EDIT_CATEGORY),
            content = {
                EditDetailOption(title = "미분류")
            }
        )
        Spacer(
            modifier = Modifier
                .height(BORDER_SIZE)
                .fillMaxWidth()
                .background(color = Color.Gray.copy(alpha = 0.8f))
        )
        EditItem(
            title = stringResource(id = R.string.EDIT_COUNTERPART),
            content = {
                EditDetailOption(title = "라온약국")
            }
        )
        Spacer(
            modifier = Modifier
                .height(BORDER_SIZE)
                .fillMaxWidth()
                .background(color = Color.Gray.copy(alpha = 0.8f))
        )
        EditItem(
            title = stringResource(
                id = when (editItem.type) {
                    is Transaction.Income -> {
                        R.string.EDIT_INCOME_ACCOUNT
                    }

                    is Transaction.Expense -> {
                        R.string.EDIT_EXPENSE_ACCOUNT
                    }

                    is Transaction.Transfer -> {
                        R.string.EDIT_TRANSFER_ACCOUNT
                    }
                }
            ),
            content = {
                EditDetailOption(title = "체크카드")
            }
        )
        Spacer(
            modifier = Modifier
                .height(BORDER_SIZE)
                .fillMaxWidth()
                .background(color = Color.Gray.copy(alpha = 0.8f))
        )
        EditItem(
            title = stringResource(id = R.string.EDIT_DATE),
            content = {
                EditDetailOption(title = "2024년 6월 4일")
            }
        )
        Spacer(
            modifier = Modifier
                .height(BORDER_SIZE)
                .fillMaxWidth()
                .background(color = Color.Gray.copy(alpha = 0.8f))
        )
        EditItem(
            title = stringResource(id = R.string.EDIT_MEMO),
            content = {
                EditDetailOption(title = "입력하세요")
            }
        )
        Spacer(
            modifier = Modifier
                .height(BORDER_SIZE)
                .fillMaxWidth()
                .background(color = Color.Gray.copy(alpha = 0.8f))
        )
        if (editItem.type is Transaction.Expense) {
            EditItem(
                title = stringResource(id = R.string.EDIT_EXCLUDE_BUDGET),
                content = {
                    EditToggleSwitch()
                }
            )
            Spacer(
                modifier = Modifier
                    .height(BORDER_SIZE)
                    .fillMaxWidth()
                    .background(color = Color.Gray.copy(alpha = 0.8f))
            )
        }
    }
}