package team.wbt.feature.main.edit.model

import team.wbt.feature.main.base.Event
import team.wbt.feature.main.base.SideEffect

sealed class EditContract {

    // TODO viewState

    sealed class EditEvent: Event {
        data object OnBackPressed: EditEvent()
    }

    sealed class EditSideEffect: SideEffect {
        data object NavigateUp: EditSideEffect()
    }
}