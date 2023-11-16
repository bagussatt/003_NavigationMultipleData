package com.example.xx

import androidx.lifecycle.ViewModel
import com.example.xx.data.KontakUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat


private const val HARGA_PER_CUP = 5000

class PociViewModel : ViewModel() {

    private val _stateUi = MutableStateFlow(KontakUIState())
    val stateUi: StateFlow<KontakUIState> = _stateUi.asStateFlow()

    fun setJumlah(jmlEsJumbo: Int){
        _stateUi.update{
                stateSaatIni -> stateSaatIni.copy(
            jumlah = jmlEsJumbo,
            harga = hitungHarga(jumlah = jmlEsJumbo)
        )
        }
    }

    fun setRasa(rasaPilihan: String){
        _stateUi.update{
                stateSaatIni -> stateSaatIni.copy(
            rasa = rasaPilihan)
        }
    }

    fun resetOrder(){
        _stateUi.value = KontakUIState()
    }

    fun hitungHarga(jumlah: Int = _stateUi.value.jumlah):String{
        val kalkulasiHarga = jumlah * HARGA_PER_CUP

        return NumberFormat.getNumberInstance().format(kalkulasiHarga)

    }

    fun setContact(listContact: MutableList<String>){
        _stateUi.update{
                stateSaatIni ->
            stateSaatIni.copy(
                nama = listContact[0],
                noHp = listContact[1],
                alamat = listContact[2]
            )
        }
    }
}