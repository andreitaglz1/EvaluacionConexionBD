package ni.edu.uca.sistematicopersistencia.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ni.edu.uca.sistematicopersistencia.data.database.dao.ProductoDao
import ni.edu.uca.sistematicopersistencia.data.database.dao.UserDao
import ni.edu.uca.sistematicopersistencia.data.database.entities.EntityProducto
import ni.edu.uca.sistematicopersistencia.data.database.entities.EntityUser

@Database(entities = [EntityProducto::class, EntityUser::class], version =1, exportSchema = false )
abstract class BaseDatos: RoomDatabase(){
    abstract fun productoDao(): ProductoDao
    abstract fun userDao():UserDao

    companion object{
        @Volatile
        private var INSTANCE: BaseDatos?= null

        fun obtBaseDatos(context: Context):BaseDatos{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDatos::class.java,
                    "basedatos"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}