package de.philipp.photoapp.data

import retrofit2.http.GET

interface PhotoApi {

    @GET("photos")
    suspend fun getPhotos(): List<Photo>
}