package com.technical.domain

interface CharacterRepository {
    suspend fun getCharacter(page: Int): Result<List<CharacterModel>>
}