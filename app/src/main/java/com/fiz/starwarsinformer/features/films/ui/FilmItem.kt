package com.fiz.starwarsinformer.features.films.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiz.starwarsinformer.R
import com.fiz.starwarsinformer.features.films.domain.models.Film

@Composable
fun FilmItem(
    film: Film,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            RowText(stringResource(R.string.title), film.title)

            Spacer(modifier = Modifier.height(8.dp))
            RowText(stringResource(R.string.created), film.created)

            Spacer(modifier = Modifier.height(8.dp))
            RowText(stringResource(R.string.director), film.director)

            Spacer(modifier = Modifier.height(8.dp))
            RowText(stringResource(R.string.edited), film.edited)

            Spacer(modifier = Modifier.height(8.dp))
            RowText(stringResource(R.string.episodeId), film.episodeId)

            Spacer(modifier = Modifier.height(8.dp))
            RowText(stringResource(R.string.openingCrawl), film.openingCrawl)

            Spacer(modifier = Modifier.height(8.dp))
            RowText(stringResource(R.string.producer), film.producer)

            Spacer(modifier = Modifier.height(8.dp))
            RowText(stringResource(R.string.releaseData), film.releaseDate)

            Spacer(modifier = Modifier.height(8.dp))
            RowText(stringResource(R.string.url), film.url)

            Spacer(modifier = Modifier.height(8.dp))
            RowList(stringResource(R.string.characters), film.characters)

            Spacer(modifier = Modifier.height(8.dp))
            RowList(stringResource(R.string.planets), film.planets)

            Spacer(modifier = Modifier.height(8.dp))
            RowList(stringResource(R.string.species), film.species)

            Spacer(modifier = Modifier.height(8.dp))
            RowList(stringResource(R.string.starships), film.starships)

            Spacer(modifier = Modifier.height(8.dp))
            RowList(stringResource(R.string.vehicles), film.vehicles)


        }
    }

}

@Composable
fun RowList(
    name: String,
    value: List<String>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(4.dp))

        Column(modifier = Modifier.weight(2f)) {
            value.forEach {
                Text(
                    text = it,
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

    }
}


@Composable
fun RowText(
    name: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = value,
            fontWeight = FontWeight.Light,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier.weight(2f)
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreviewFilmItem() {
//    StarWarsInformerTheme {
//        FilmItem(film)
//    }
//}