package com.example.xx

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.xx.data.KontakUIState


@Composable
fun HalamanDua(
    contactUiState: KontakUIState,
    onBackButtonClicked: () -> Unit,
){
    Column (
        verticalArrangement = Arrangement.Center,

        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(text = "Nama")
        Text(text = contactUiState.nama)
        Divider()

        Text(text = "Nomer Telepon")
        Text(text = contactUiState.noHp)
        Divider()

        Text(text = "Alamat")
        Text(text = contactUiState.alamat)

        Spacer(modifier = Modifier.padding(16.dp))

        Row (
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Button(onClick = { onBackButtonClicked}) {
                Text(text = stringResource(id = R.string.back))
            }
        }

    }
}