package ni.edu.uca.sistematicopersistencia.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("tbl_user")
data class EntityUser(
    @PrimaryKey(autoGenerate = true)
    val idUser: Int,
    @ColumnInfo("userName")
    val user:String,
    @ColumnInfo("userPassword")
    val password: String,
    @ColumnInfo("userEmail")
    val email: String
)