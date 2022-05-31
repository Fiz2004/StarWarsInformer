package com.fiz.starwarsinformer.features.films.ui

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.fiz.starwarsinformer.R

@Composable
fun FilmScreen(
    navigator: NavController,
    viewModel: FilmsViewModel = viewModel()
) {
    val state = viewModel.state

    if (state.error == null) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = stringResource(R.string.films),
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = MaterialTheme.colorScheme.onBackground,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.films.size) { index ->
                    val film = state.films[index]
                    FilmItem(
                        film = film,
                        modifier = Modifier
                            .clickable {
                                // TODO Navigate FilmInfo screen
                            }
                            .padding(16.dp)
                    )
                    if (index < state.films.size) {
                        Divider(
                            modifier = Modifier.padding(
                                horizontal = 16.dp
                            )
                        )
                    }
                }
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (state.isLoading) {
            CircularProgressAnimated(modifier = Modifier.align(Alignment.Center))
        } else if (state.error != null) {
            Text(
                text = stringResource(state.error),
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}

@Composable
private fun CircularProgressAnimated(modifier: Modifier = Modifier) {
    val progressValue = 1f
    val infiniteTransition = rememberInfiniteTransition()

    val progressAnimationValue by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = progressValue, animationSpec = infiniteRepeatable(animation = tween(900))
    )

    CircularProgressIndicator(modifier = modifier, progress = progressAnimationValue)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewFilmScreen() {
//    StarWarsInformerTheme {
//        FilmScreen("Android")
//    }
}