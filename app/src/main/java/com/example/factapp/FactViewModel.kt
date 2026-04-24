package com.example.factapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.GetRandomFactUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FactViewModel @Inject constructor(
    private val getRandomFactUseCase: GetRandomFactUseCase
) : ViewModel() {

    private val _factText = MutableStateFlow("Нажми на кнопку, чтобы узнать факт")
    val factText: StateFlow<String> = _factText

    fun fetchFact() {
        viewModelScope.launch {
            _factText.value = "Загрузка..."
            getRandomFactUseCase().onSuccess { fact ->
                _factText.value = fact.text
            }.onFailure {
                _factText.value = "Ошибка: ${it.message}"
            }
        }
    }
}