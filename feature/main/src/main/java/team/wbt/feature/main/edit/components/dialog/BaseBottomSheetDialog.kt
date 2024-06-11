package team.wbt.feature.main.edit.components.dialog

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import team.wbt.feature.main.edit.components.dialog.components.DialogContentWrapper
import team.wbt.feature.main.edit.components.dialog.components.DialogTitleWrapper
import team.wbt.feature.main.edit.model.ui.dialog.DialogContent
import team.wbt.feature.main.edit.model.ui.dialog.DialogTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseBottomSheetDialog(
    sheetState: SheetState,
    onDismissRequest: () -> Unit,
    dialogTitle: DialogTitle,
    dialogContent: DialogContent,
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = sheetState,
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.White,
    ) {
        DialogTitleWrapper(title = dialogTitle)
        DialogContentWrapper(
            dialogContent = dialogContent
        )
    }
}