package de.philipp.photoapp.photodetails

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import de.philipp.photoapp.data.Photo
import de.philipp.photoapp.ui.composable.DefaultTopAppBar
import de.philipp.photoapp.ui.theme.PhotoAppTheme

@Composable
fun PhotoDetailsView(photo: Photo, onBack: () -> Unit) {
    PhotoAppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultTopAppBar(title = photo.title, onBack = onBack)
            PhotoDetails(photo = photo)
        }
        BackHandler {
            onBack()
        }
    }
}

@Composable
fun PhotoDetails(photo: Photo) {
    Image(
        painter = rememberImagePainter(photo.url),
        contentDescription = null,
        modifier = Modifier
            .size(256.dp)
            .padding(32.dp)
    )
}
