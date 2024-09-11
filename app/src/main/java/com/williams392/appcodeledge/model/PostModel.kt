package com.williams392.appcodeledge.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class PostModel(
    @SerializedName("id_post") val idPost: Long,
    @SerializedName("titulo") val titulo: String,
    @SerializedName("descripcion") val descripcion: String,
    @SerializedName("contenido") val contenido: String,
    @SerializedName("fecha_publicacion") val fechaPublicacion: LocalDateTime,
    @SerializedName("tipoPost") val tipoPost: TiposPostModel,
)
