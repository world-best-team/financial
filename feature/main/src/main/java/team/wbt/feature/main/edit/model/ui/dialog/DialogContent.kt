package team.wbt.feature.main.edit.model.ui.dialog

import team.wbt.feature.main.edit.model.CategoryModel
import java.util.Date

sealed class DialogContent {

    data class Category(
        val categories: List<CategoryModel>,
        val onClick: (CategoryModel) -> Unit,
    ) : DialogContent()

    data class Calendar(
        val date: Date,
    ) : DialogContent()
}