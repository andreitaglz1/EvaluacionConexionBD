package ni.edu.uca.sistematicopersistencia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ni.edu.uca.sistematicopersistencia.data.database.BaseDatos
import ni.edu.uca.sistematicopersistencia.data.database.entities.EntityProducto
import ni.edu.uca.sistematicopersistencia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var room: BaseDatos
    private lateinit var producto: EntityProducto

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        room = Room.databaseBuilder(this, BaseDatos::class.java, "basedatos").build()

        binding.btnAdd.setOnClickListener {
            val nombre = binding.etNombreProd.text.toString()
            val precio = binding.etPrecio.text.toString().toDoubleOrNull()
            val existencia = binding.etExistencia.text.toString().toIntOrNull()

            val producto = EntityProducto(null, nombre, precio, existencia)

            GlobalScope.launch {
                room.productoDao().insertarReg(producto)
            }
            Toast.makeText(this, "Se agregó correctamente", Toast.LENGTH_SHORT).show()
        }

    }

}