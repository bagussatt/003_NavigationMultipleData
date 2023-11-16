package com.example.xx

import androidx.lifecycle.ViewModel
import com.example.xx.data.KontakUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class KontakViewModel: ViewModel() {
    private val _stateUI = MutableStateFlow(KontakUIState())
    val stateUI:StateFlow<KontakUIState> = _stateUI.asStateFlow()

    fun setKontak(listKontak: MutableList<String>){
        _stateUI.update { nowstate ->
            nowstate.copy(
                nama = listKontak[0],
                noHp = listKontak[1],
                alamat = listKontak[2]
            )
        }
    }
}