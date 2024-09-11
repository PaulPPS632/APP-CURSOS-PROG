package com.williams392.appcodeledge.provider

import com.williams392.appcodeledge.model.PostModel
import com.williams392.appcodeledge.network.RetrofitInstance
import com.williams392.appcodeledge.routes.PostRoutes
import retrofit2.Response

class PostProvider {

    private val postRoutes: PostRoutes = RetrofitInstance().getRetrofitInstance().create(PostRoutes::class.java)

    suspend fun obtenerPosts(): Response<List<PostModel>> {
        return postRoutes.obtenerPosts()
    }

    suspend fun obtenerPostPorId(id: Long): Response<PostModel> {
        return postRoutes.obtenerPostPorId(id)
    }

    suspend fun agregarPost(post: PostModel): Response<PostModel> {
        return postRoutes.agregarPost(post)
    }

    suspend fun actualizarPost(id: Long, post: PostModel): Response<PostModel> {
        return postRoutes.actualizarPost(id, post)
    }

    suspend fun eliminarPost(id: Long): Response<Map<String, Boolean>> {
        return postRoutes.eliminarPost(id)
    }

}