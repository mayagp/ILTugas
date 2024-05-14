package com.example.tugasil.data

import com.example.tugasil.model.DataFake
import com.example.tugasil.model.FavArtis
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class DataConf {

    private val favArtis = mutableListOf<FavArtis>()
    init{
        if (favArtis.isEmpty()){
            DataFake.Artis.forEach {

            }
        }
    }


    fun getAllArtisList(): Flow<List<FavArtis>> {
        return flowOf(favArtis)
    }

    fun getArtisById(artisId: Long): FavArtis {
        return favArtis.first { it.artisKpop.id.toLong() == artisId }
    }


    fun ArtisList(artisId: Int): Flow<Boolean> {
        val index = favArtis.indexOfFirst { it.artisKpop.id == artisId }
        val result = if (index >= 0) {
            val artislist = favArtis[index]
            favArtis[index] = artislist.copy(artislist.artisKpop)
            true
        } else {
            false
        }
        return flowOf(result)
    }
}

