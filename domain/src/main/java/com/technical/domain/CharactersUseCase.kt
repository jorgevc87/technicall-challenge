package com.technical.domain

class CharactersUseCase(private val repo: CharacterRepository) {
    suspend fun getCharacter(page: Int) = repo.getCharacter(page)
}