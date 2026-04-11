package com.technical.data

import com.technical.domain.CharacterModel
import com.technical.domain.CharacterRepository

class CharacterRepositoryImpl(
    private val api: ApiService
) : CharacterRepository {

    override suspend fun getCharacter(page: Int): Result<List<CharacterModel>> {
        return try {
            val response = api.getCharacters(page)
            val list = response.results.map { dto ->
                CharacterModel(
                    dto.id, dto.name, dto.status, dto.image
                )
            }

            Result.success(list)
        } catch (ex: Exception) {
            Result.failure(ex)
        }
    }
}