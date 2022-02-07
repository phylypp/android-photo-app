package de.philipp.photoapp

import de.philipp.photoapp.data.Photo
import de.philipp.photoapp.data.PhotoRepository
import de.philipp.photoapp.utils.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ListViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun loadPhoto() {
        runTest {
            val photo = Photo(
                albumId = 1,
                id = 1,
                thumbnailUrl = "",
                title = "title",
                url = ""
            )
            val photoRepository = mockk<PhotoRepository>().apply {
                coEvery { getPhotos() }.returns(listOf(photo))
            }

            val viewModel = MainViewModel(photoRepository)

            assertEquals(photo, viewModel.photos.first())
        }
    }
}