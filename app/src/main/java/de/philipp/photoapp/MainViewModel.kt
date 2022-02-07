package de.philipp.photoapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.philipp.photoapp.data.Photo
import de.philipp.photoapp.data.PhotoRepository
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.io.IOException

val mainViewModelModule = module {
    viewModel { MainViewModel(get()) }
}

class MainViewModel(private val photoRepo: PhotoRepository) : ViewModel() {

    var photos: List<Photo> by mutableStateOf(emptyList())
        private set

    var selectedPhoto: Photo? by mutableStateOf(null)
        private set

    init {
        loadPhotos()
    }

    private fun loadPhotos() {
        viewModelScope.launch {
            try {
                photos = photoRepo.getPhotos()
            } catch (e: IOException) {
                e.printStackTrace()
                // TODO handle error
            }
        }
    }

    fun onPhotoSelected(photo: Photo) {
        selectedPhoto = photo
    }

    fun onCloseDetails() {
        selectedPhoto = null
    }
}