package de.philipp.photoapp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class PhotoRepositoryImp : PhotoRepository {

    private val photoApiImp: PhotoApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(PhotoApi::class.java)

    override suspend fun getPhotos() = photoApiImp.getPhotos()
}