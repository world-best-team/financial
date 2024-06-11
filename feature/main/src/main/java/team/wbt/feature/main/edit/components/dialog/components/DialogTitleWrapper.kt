package team.wbt.feature.main.edit.components.dialog.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import team.wbt.feature.main.edit.model.ui.dialog.DialogTitle

@Composable
fun DialogTitleWrapper(title: DialogTitle) {
    when (title) {
        is DialogTitle.TitleOnly -> {
            DefaultDialogTitle(title)
        }

        is DialogTitle.TitleWithSubTitle -> {
            CalendarDialogTitle(title)
        }
    }
}

@Composable
fun DefaultDialogTitle(title: DialogTitle.TitleOnly) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = title.title,
        )
    }
}

@Composable
fun CalendarDialogTitle(title: DialogTitle.TitleWithSubTitle) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = title.title,
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = title.subTitle,
            color = Color.Gray
        )
    }
}