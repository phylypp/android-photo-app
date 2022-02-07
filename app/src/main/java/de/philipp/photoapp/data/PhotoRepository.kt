package de.philipp.photoapp.data

import org.koin.dsl.module

val photoRepositoryModule = module {
    single { providePhotoRepository() }
}

private fun providePhotoRepository(): PhotoRepository = PhotoRepositoryImp()

interface PhotoRepository {

    suspend fun getPhotos(): List<Photo>
}