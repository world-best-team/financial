package team.wbt.feature.main.edit.components.dialog.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import team.wbt.feature.main.edit.model.ui.dialog.DialogContent

@Composable
fun DialogContentWrapper(
    dialogContent: DialogContent,
) {
    when (dialogContent) {
        is DialogContent.Category -> {
            DefaultDialogContent(dialogContent = dialogContent)
        }

        is DialogContent.Calendar -> {
            CalendarDialogContent(dialogContent = dialogContent)
        }
    }
}

@Composable
fun DefaultDialogContent(dialogContent: DialogContent.Category) {
    LazyColumn {
        items(dialogContent.categories, key = { it.id }) { item ->
            CategoryItem(
                category = item,
                onClick = dialogContent.onClick
            )
        }
    }
}

@Composable
fun CalendarDialogContent(dialogContent: DialogContent.Calendar) {
    // calendar choice WheelDatePicker 만들기
}