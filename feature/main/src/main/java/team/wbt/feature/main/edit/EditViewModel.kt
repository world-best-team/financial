package team.wbt.feature.main.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import team.wbt.feature.main.edit.model.EditEvent
import team.wbt.feature.main.edit.model.EditModel
import team.wbt.feature.main.edit.model.EditSideEffect
import team.wbt.feature.main.edit.model.EditViewState
import team.wbt.feature.main.edit.model.Transaction
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
) : ViewModel() {

    private val _state = MutableStateFlow<EditViewState>(EditViewState.Loading)
    val state get() = _state.asStateFlow()

    private val _event = MutableSharedFlow<EditEvent>()
    val event get() = _event.asSharedFlow()

    private val _effect = Channel<EditSideEffect>()
    val effect get() = _effect.receiveAsFlow()

    init {

        viewModelScope.launch {
            _event.collect(::handleEvent)
        }

        createItem()
    }

    fun createItem() {
        viewModelScope.launch {
            setState(EditViewState.Loading)
            delay(1_000L)
            setState(
                EditViewState.Success(
                    editItem = EditModel(
                        title = "라온 약국",
                        amount = "10000",
                        category = "미분류",
                        counterPart = "라온 약국",
                        paymentMethod = "토스 카드",
                        date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()),
                        memo = "",
                        type = Transaction.Expense(excludeFromBudget = false)
                    )
                )
            )
        }
    }

    private fun setState(state: EditViewState) {
        _state.value = state
    }

    private fun handleEvent(event: EditEvent) {
        viewModelScope.launch {
            when (event) {
                is EditEvent.ShowCategory -> {
                    setEffect(EditSideEffect.ShowCategory)
                }
                is EditEvent.EditCategory -> {
                    val curr = (state.value as EditViewState.Success).editItem
                    setState(
                        EditViewState.Success(
                            editItem = curr.copy(
                                category = event.categoryModel?.let { it.name } ?: curr.category
                            )
                        )
                    )
                }
                else -> {}
            }
        }
    }

    fun setEvent(event: EditEvent) {
        viewModelScope.launch {
            _event.emit(event)
        }
    }

    fun setEffect(effect : EditSideEffect){
        viewModelScope.launch {
            _effect.send(effect)
        }
    }
}