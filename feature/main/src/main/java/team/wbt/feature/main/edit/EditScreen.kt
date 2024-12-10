package team.wbt.feature.main.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.collectLatest
import team.wbt.feature.main.R
import team.wbt.feature.main.edit.components.EditCategoryButtonList
import team.wbt.feature.main.edit.components.EditDetailOption
import team.wbt.feature.main.edit.components.EditItem
import team.wbt.feature.main.edit.components.EditToggleSwitch
import team.wbt.feature.main.edit.components.EditTopBar
import team.wbt.feature.main.edit.components.dialog.CategoryBottomSheet
import team.wbt.feature.main.edit.model.EditEvent
import team.wbt.feature.main.edit.model.EditModel
import team.wbt.feature.main.edit.model.EditSideEffect
import team.wbt.feature.main.edit.model.EditViewState
import team.wbt.feature.main.edit.model.Transaction


private val BORDER_SIZE = 1.dp

@Composable
fun EditRoute(
    onBackClick: () -> Unit,
    viewModel: EditViewModel = hiltViewModel(),
) {
    val editState by viewModel.state.collectAsStateWithLifecycle(
        // lifecycle 2.8.0 버전 이슈
        // https://daengdaeng.medium.com/compositionlocal-locallifecycleowner-not-present-a83c874c28e0
        lifecycleOwner = androidx.compose.ui.platform.LocalLifecycleOwner.current
    )

    var showCategoryBottomSheet by remember { mutableStateOf(false) }

    LaunchedEffect(true) {
        viewModel.effect.collectLatest { sideEffect ->
            when (sideEffect) {
                is EditSideEffect.ShowCategory -> {
                    showCategoryBottomSheet = true
                }
            }
        }
    }

    if (showCategoryBottomSheet) {
        CategoryBottomSheet(
            onDismiss = { showCategoryBottomSheet = false },
            onClick = {
                viewModel.setEvent(EditEvent.EditCategory(it))
                showCategoryBottomSheet = false
            }
        )
    }

    EditScreen(
        editState = editState,
        onBackClick = onBackClick,
        onEffect = viewModel::setEvent,
    )
}

@Composable
internal fun EditScreen(
    editState: EditViewState,
    onBackClick: () -> Unit,
    onEffect: (EditEvent) -> Unit,
) {
    when (editState) {
        is EditViewState.Loading -> {
            EditLoading()
        }

        is EditViewState.Success -> {
            Column(
                modifier = Modifier
            ) {
                EditTopBar(onBackClick = onBackClick)
                EditTopDetail(
                    title = editState.editItem.title,
                    amount = editState.editItem.amount
                )
                Spacer(modifier = Modifier.height(10.dp))
                EditListScreen(
                    editItem = editState.editItem,
                    showCategoryBottomSheet = { onEffect(EditEvent.ShowCategory) },
                    showShowPaymentMethodBottomSheet = { onEffect(EditEvent.ShowPaymentMethod) },
                    showDatePickerBottomSheet = { onEffect(EditEvent.ShowDatePicker) },
                )
            }
        }
    }
}

@Composable
private fun EditLoading() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
private fun EditTopDetail(
    title: String,
    amount: String,
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
            text = title,
            fontSize = 18.sp
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = amount,
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
            text = "명세서 | 인식금액 ${amount}원",
            textDecoration = TextDecoration.Underline,
            color = Color.Gray.copy(alpha = 0.5f)
        )
    }
}

@Composable
private fun EditListScreen(
    modifier: Modifier = Modifier,
    editItem: EditModel,
    showCategoryBottomSheet: () -> Unit,
    showShowPaymentMethodBottomSheet: () -> Unit,
    showDatePickerBottomSheet: () -> Unit,
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
                EditCategoryButtonList(
                    currentType = editItem.type
                )
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
                EditDetailOption(
                    title = editItem.category,
                    onClick = showCategoryBottomSheet
                )
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
                EditDetailOption(title = editItem.title)
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
                EditDetailOption(
                    title = editItem.paymentMethod,
                    onClick = showShowPaymentMethodBottomSheet
                )
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
                EditDetailOption(
                    title = editItem.dateToString(),
                    onClick = showDatePickerBottomSheet
                )
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
                EditDetailOption(title = editItem.memo)
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