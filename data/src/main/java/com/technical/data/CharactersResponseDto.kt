package com.technical.data

import com.google.gson.annotations.SerializedName

data class CharactersResponseDto(
    @SerializedName("results") var results: List<CharacterDto>,
)

data class CharacterDto(
    @SerializedName("id") var id: Int?,
    @SerializedName("name") var name: String?,
    @SerializedName("status") var status: String?,
    @SerializedName("image") var image: String?,
)