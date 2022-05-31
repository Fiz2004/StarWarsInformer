package com.fiz.starwarsinformer.main_screen.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.fiz.starwarsinformer.features.films.ui.FilmScreen
import com.fiz.starwarsinformer.features.films.ui.FilmsViewModel

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: FilmsViewModel = viewModel()
) {
    FilmScreen(navController, viewModel)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewMainScreen() {
//    StarWarsInformerTheme {
//        MainScreen()
//    }
}