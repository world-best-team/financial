package team.wbt.feature.main.edit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import team.wbt.core.designsystem.theme.FinancialTheme

private val ICON_SIZE = 24.dp
private val TOP_BAR_SIZE = 56.dp

@Composable
internal fun EditTopBar(
    onBackClick: () -> Unit = {},
    contentColor: Color = Color.White, // TODO theme
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(TOP_BAR_SIZE)
            .background(contentColor)
    ) {
        IconButton(
            onClick = onBackClick,
            modifier = Modifier.size(48.dp)
                .align(Alignment.CenterStart)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(ICON_SIZE),
                contentDescription = null
            )
        }
    }
}


@Preview
@Composable
private fun EditTopBarPreview() {
    FinancialTheme {
        EditTopBar()
    }
}