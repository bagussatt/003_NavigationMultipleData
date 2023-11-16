package com.example.xx

import android.text.Layout.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanSatu(
    onSubmitButtonClicked: (MutableList<String>) -> Unit
){
    var nama by rememberSaveable { mutableStateOf("") }
    var noHp by rememberSaveable { mutableStateOf("") }
    var alamat by rememberSaveable { mutableStateOf("") }
    var ListData: MutableList<String> = mutableListOf(nama, noHp, alamat)

    Column (
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(value = nama, onValueChange = {nama = it}, label = { Text(text = "Nama")})
        OutlinedTextField(value = noHp, onValueChange = {noHp = it}, label = { Text(text = "Nomer Telepon")})
        OutlinedTextField(value = alamat, onValueChange = {alamat = it}, label = { Text(text = "Alamat")})

        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = { onSubmitButtonClicked(ListData) }) {
            Text(text = stringResource(id = R.string.next))
        }
    }
}