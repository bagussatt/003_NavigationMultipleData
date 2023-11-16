package com.example.xx

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel

enum class Controller{
    Formulir,
    Detail
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactApp(
    viewModel: KontakViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold { innerPadding ->
        val uiState by viewModel.stateUI.collectAsState()

        NavHost(navController = navController,
            startDestination = Controller.Formulir.name,
            modifier = Modifier.padding(innerPadding)) {

            composable(Controller.Formulir.name) {
                HalamanSatu(onSubmitButtonClicked = { contactData ->
                    viewModel.setKontak(contactData)
                    navController.navigate(Controller.Detail.name)
                })
            }

            composable(Controller.Detail.name) {
                HalamanDua(
                    contactUiState = uiState,
                    onBackButtonClicked = {
                        navController.popBackStack(
                            Controller.Formulir.name,
                            inclusive = false
                        )
                    }
                )
            }
        }
    }
}
