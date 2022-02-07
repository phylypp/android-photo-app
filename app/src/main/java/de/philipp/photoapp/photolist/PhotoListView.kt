package de.philipp.photoapp.photolist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.philipp.photoapp.R
import de.philipp.photoapp.data.Photo
import de.philipp.photoapp.ui.composable.DefaultTopAppBar
import de.philipp.photoapp.ui.theme.PhotoAppTheme

@Composable
fun PhotoListView(photos: List<Photo>, onPhotoSelected: (Photo) -> Unit) {
    PhotoAppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            DefaultTopAppBar(title = stringResource(id = R.string.photos))
            PhotoList(photos = photos, onPhotoSelected = onPhotoSelected)
        }
    }
}

@Composable
fun PhotoList(photos: List<Photo>, onPhotoSelected: (Photo) -> Unit) {
    LazyColumn {
        itemsIndexed(items = photos) { index, photo ->
            PhotoListItem(photo = photo, onPhotoSelected = onPhotoSelected)
            if (index != photos.size) {
                Divider()
            }
        }
    }
}

@Composable
fun PhotoListItem(photo: Photo, onPhotoSelected: (Photo) -> Unit) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onPhotoSelected(photo) }
            .padding(all = 24.dp),
        text = photo.title
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PhotoAppTheme {
        PhotoList(
            listOf(
                Photo(
                    albumId = 1,
                    id = 1,
                    thumbnailUrl = "",
                    title = "TITLE",
                    url = ""
                )
            )
        ) {}
    }
}