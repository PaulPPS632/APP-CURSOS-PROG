package com.williams392.appcodeledge.model

import com.google.gson.annotations.SerializedName

data class TiposPostModel(
    @SerializedName("id_tipo_post") val id: Long,
    @SerializedName("nombre_tipo") val nombre_tipo: String,
    @SerializedName("descripcion") val descripcion: String
)
