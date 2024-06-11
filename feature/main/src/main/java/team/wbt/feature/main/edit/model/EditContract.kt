package team.wbt.feature.main.edit.model

import team.wbt.feature.main.base.Event
import team.wbt.feature.main.base.SideEffect
import team.wbt.feature.main.base.ViewState

sealed interface EditViewState : ViewState {
    data object Loading : EditViewState
    data class Success(
        val editItem: EditModel,
    ) : EditViewState
}

sealed interface EditEvent : Event {
    data class EditCategory(
        val categoryModel: CategoryModel?
    ): EditEvent
    data object ShowCategory : EditEvent
    data object ShowPaymentMethod : EditEvent
    data object ShowDatePicker : EditEvent
}

sealed interface EditSideEffect : SideEffect {
    data object ShowCategory : EditSideEffect
}