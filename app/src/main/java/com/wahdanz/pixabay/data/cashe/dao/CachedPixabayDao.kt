package com.wahdanz.pixabay.data.cashe.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wahdanz.pixabay.data.cashe.dto.PixabayCache
import com.wahdanz.pixabay.data.model.PixabayModel

@Dao
interface CachedPixabayDao {
    @Query("SELECT * FROM pixabay_table where `query` = :query")
    suspend fun getAllPixbays(query: String): List<PixabayCache>
    @Query("SELECT * FROM pixabay_table Where id = :id")
    suspend fun getPixbay(id: Int): PixabayCache
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllPixbays(pixbays: List<PixabayCache>)
}
