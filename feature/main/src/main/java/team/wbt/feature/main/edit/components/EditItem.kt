package team.wbt.feature.main.edit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val EDIT_HEIGHT_SIZE = 60.dp

@Composable
internal fun EditItem(
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