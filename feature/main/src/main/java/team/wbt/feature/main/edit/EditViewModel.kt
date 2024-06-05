package team.wbt.feature.main.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import team.wbt.feature.main.edit.model.EditContract
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
) : ViewModel() {

    private val _event = MutableSharedFlow<EditContract.EditEvent>()
    val event get() = _event.asSharedFlow()

    private val _effect = Channel<EditContract.EditSideEffect>()
    val effect get() = _effect.receiveAsFlow()

    init {

        viewModelScope.launch {
            _event.collect(::handleEvent)
        }
    }

    private fun handleEvent(event: EditContract.EditEvent) {
        viewModelScope.launch {
            when (event) {
                is EditContract.EditEvent.OnBackPressed -> {
                    _effect.send(EditContract.EditSideEffect.NavigateUp)
                }
            }
        }
    }

    fun setEvent(event: EditContract.EditEvent) {
        viewModelScope.launch {
            _event.emit(event)
        }
    }
}