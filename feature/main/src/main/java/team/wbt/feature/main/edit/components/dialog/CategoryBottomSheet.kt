package team.wbt.feature.main.edit.components.dialog

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.launch
import team.wbt.feature.main.R
import team.wbt.feature.main.edit.model.CategoryModel
import team.wbt.feature.main.edit.model.ui.dialog.DialogContent
import team.wbt.feature.main.edit.model.ui.dialog.DialogTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryBottomSheet(
    onDismiss: () -> Unit,
    onClick: (CategoryModel) -> Unit,
//    categories: List<Category>? TODO get Categories??
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    BaseBottomSheetDialog(
        sheetState = sheetState,
        onDismissRequest = {
            scope.launch {
                sheetState.hide()
            }.invokeOnCompletion {
                onDismiss()
            }
        },
        dialogTitle = DialogTitle.TitleWithSubTitle(
            title = stringResource(id = R.string.EDIT_CATEGORY),
            subTitle = stringResource(id = R.string.EDIT)
        ),
        dialogContent = DialogContent.Category(
            categories = listOf(
                CategoryModel(
                    id = 0,
                    name = "휴대폰"
                ),
                CategoryModel(
                    id = 1,
                    name = "인터넷"
                ),
                CategoryModel(
                    id = 3,
                    name = "월세"
                ),
                CategoryModel(
                    id = 4,
                    name = "관리비"
                ),
                CategoryModel(
                    id = 5,
                    name = "가스비"
                ),
            ),
            onClick = { category ->
                scope.launch {
                    sheetState.hide()
                }.invokeOnCompletion {
                    onClick(category)
                }
            }
        )
    )
}