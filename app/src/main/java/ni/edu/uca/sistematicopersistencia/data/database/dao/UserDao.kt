package ni.edu.uca.sistematicopersistencia.data.database.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ni.edu.uca.sistematicopersistencia.data.database.entities.EntityUser


@Dao
interface UserDao {

    @Query("SELECT *FROM tbl_user")
    fun getAllUsers(): Flow<List<EntityUser>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: EntityUser)

    @Update
    suspend fun updateUser(user: EntityUser)

    @Delete
    suspend fun deleteUser(user: EntityUser)
}