package de.philipp.photoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.Composable
import de.philipp.photoapp.data.Photo
import de.philipp.photoapp.photodetails.PhotoDetailsView
import de.philipp.photoapp.photolist.PhotoListView
import org.koin.java.KoinJavaComponent.inject

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by inject(MainViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Views(
                photos = viewModel.photos,
                selectedPhoto = viewModel.selectedPhoto,
                onCloseDetails = { viewModel.onCloseDetails() },
                onPhotoSelected = { viewModel.onPhotoSelected(it) }
            )
        }
    }
}

@VisibleForTesting
@Composable
fun Views(
    photos: List<Photo>,
    selectedPhoto: Photo?,
    onCloseDetails: () -> Unit,
    onPhotoSelected: (Photo) -> Unit
) {
    if (selectedPhoto != null) {
        PhotoDetailsView(
            photo = selectedPhoto,
            onBack = onCloseDetails
        )
    } else {
        PhotoListView(
            photos = photos,
            onPhotoSelected = onPhotoSelected
        )
    }
}