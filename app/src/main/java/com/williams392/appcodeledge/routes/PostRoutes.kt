package com.williams392.appcodeledge.routes

import com.williams392.appcodeledge.model.PostModel
import retrofit2.Response
import retrofit2.http.*


interface PostRoutes {

    @GET("api/posts")
    suspend fun obtenerPosts(): Response<List<PostModel>>

    @GET("api/posts/{id}")
    suspend fun obtenerPostPorId(@Path("id") id: Long): Response<PostModel>

    @POST("api/posts")
    suspend fun agregarPost(@Body post: PostModel): Response<PostModel>

    @PUT("api/posts/{id}")
    suspend fun actualizarPost(@Path("id") id: Long, @Body post: PostModel): Response<PostModel>

    @DELETE("api/posts/{id}")
    suspend fun eliminarPost(@Path("id") id: Long): Response<Map<String, Boolean>>

}