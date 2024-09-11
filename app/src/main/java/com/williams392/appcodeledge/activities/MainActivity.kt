package com.williams392.appcodeledge.activities

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.williams392.appcodeledge.R
import com.williams392.appcodeledge.provider.PostProvider
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var postProvider: PostProvider
    private lateinit var titleTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var contentTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar el proveedor de datos
        postProvider = PostProvider()

        // Referencias a los elementos de la interfaz de usuario
        titleTextView = findViewById(R.id.titleTextView)
        descriptionTextView = findViewById(R.id.descriptionTextView)
        contentTextView = findViewById(R.id.contentTextView)

        // Llamar a la API para obtener el post
        getPost()

    }

    private fun getPost() {
        // Ejecutar la llamada a la API en un hilo de trabajo
        lifecycleScope.launch {
            try {
                val response = postProvider.obtenerPostPorId(1) // Asumiendo que deseas el post con ID 1
                if (response.isSuccessful) {
                    val post = response.body()
                    post?.let {
                        // Actualizar la interfaz de usuario con los datos del post
                        titleTextView.text = it.titulo
                        descriptionTextView.text = it.descripcion
                        contentTextView.text = it.contenido
                    }
                } else {
                    // Manejar el error en caso de una respuesta no exitosa
                    // Ejemplo: Mostrar un mensaje de error
                    titleTextView.text = "Error: ${response.code()}"
                }
            } catch (e: HttpException) {
                // Manejar errores de HTTP
                titleTextView.text = "HTTP Exception: ${e.message()}"
            } catch (e: IOException) {
                // Manejar errores de red
                titleTextView.text = "IOException: ${e.message}"
            }
        }
    }
}