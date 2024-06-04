package team.wbt.feature.main.edit

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import team.wbt.feature.main.R
import team.wbt.feature.main.edit.components.EditTopBar
import team.wbt.feature.main.edit.model.EditUiModel


private val BORDER_SIZE = 1.dp
private val EDIT_HEIGHT_SIZE = 60.dp

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
        val current = CategoryType.INCOME
        EditItem(
            title = stringResource(id = R.string.EDIT_TYPE),
            content = {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    EditCategoryCard(
                        editType = CategoryType.INCOME,
                        isSelected = true
                    )
                    EditCategoryCard(
                        editType = CategoryType.EXPENSE,
                    )
                    EditCategoryCard(
                        editType = CategoryType.TRANSFER,
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
                id = when (current) {
                    CategoryType.INCOME -> {
                        R.string.EDIT_INCOME_ACCOUNT
                    }

                    CategoryType.EXPENSE -> {
                        R.string.EDIT_EXPENSE_ACCOUNT
                    }

                    else -> {
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
        if (current == CategoryType.EXPENSE) {
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

@Composable
private fun EditItem(
    modifier: Modifier = Modifier,
    title: String = "",
    content: @Composable () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .height(EDIT_HEIGHT_SIZE)
            .fillMaxWidth()
            .background(color = Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = title,
            color = Color.Gray,
            modifier = modifier.width(100.dp)
        )
        content()
    }
}

enum class CategoryType {
    INCOME,
    EXPENSE,
    TRANSFER
}

@Composable
private fun EditCategoryCard(
    editType: CategoryType,
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
                            CategoryType.INCOME -> {
                                Color.Cyan
                            }

                            CategoryType.EXPENSE -> {
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
                    CategoryType.INCOME -> {
                        R.string.EDIT_TYPE_INCOME
                    }

                    CategoryType.EXPENSE -> {
                        R.string.EDIT_TYPE_EXPENSE
                    }

                    CategoryType.TRANSFER -> {
                        R.string.EDIT_TYPE_TRANSFER
                    }
                }
            ),
            textAlign = TextAlign.Center,
            color = if (isSelected) {
                when (editType) {
                    CategoryType.INCOME -> {
                        Color.Cyan
                    }

                    CategoryType.EXPENSE -> {
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

@Composable
fun EditDetailOption(
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = { onClick() },
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                modifier = Modifier.size(12.dp),
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null
            )
        }
    }
}

@Composable
fun EditToggleSwitch(
    isSelected: Boolean = false,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = isSelected,
            onCheckedChange = {},
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.primary,
                checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            )
        )
    }
}