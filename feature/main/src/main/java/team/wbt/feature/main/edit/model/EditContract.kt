package team.wbt.feature.main.edit.model

import team.wbt.feature.main.base.Event
import team.wbt.feature.main.base.SideEffect
import team.wbt.feature.main.base.ViewState

sealed class EditContract {

    // TODO viewState
    sealed interface EditViewState: ViewState {
        data object Loading: EditViewState
        data class Success(
            val editItem: EditModel
        ): EditViewState
    }

    sealed interface EditEvent: Event {
    }

    sealed interface EditSideEffect: SideEffect {
    }
}