package com.example.saludador_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp

/**
 * Punto de entrada de la aplicación donde se configura la base de la interfaz.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // preparamos el contenedor principal para que ocupe toda la pantalla con el fondo del tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HelloForm()
                }
            }
        }
    }
}

/**
 * Composable principal que renderiza un formulario de saludo interactivo.
 *
 * @param modifier modificador para ajustar el diseño y comportamiento del contenedor principal.
 */
@Composable
fun HelloForm(modifier: Modifier = Modifier) {
    // guardamos el texto introducido por el usuario para que sobreviva a rotaciones de pantalla
    var name by rememberSaveable { mutableStateOf("") }

    // almacenamos el mensaje a mostrar en pantalla para actualizarlo al pulsar el botón
    var greetingMessage by rememberSaveable { mutableStateOf("Introduce tu nombre") }

    // recuperamos el controlador del teclado virtual para interactuar con él más adelante
    val keyboardController = LocalSoftwareKeyboardController.current

    // estructuramos el contenido en vertical aplicando márgenes y una separación equitativa
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // habilitamos la entrada de datos limitando el texto a veinte caracteres y mostrando el conteo
        TextField(
            value = name,
            onValueChange = {
                if (it.length <= 20) {
                    name = it
                }
                // reseteamos el mensaje de la interfaz automáticamente si el usuario borra todo el texto
                if (it.isBlank()) {
                    greetingMessage = "Introduce tu nombre"
                }
            },
            label = { Text("Nombre") },
            supportingText = { Text("${name.length}/20") },
            modifier = Modifier.fillMaxWidth()
        )

        // mostramos el botón de acción condicionado a que haya texto válido para evitar saludos vacíos
        Button(
            onClick = {
                // disparamos la actualización de la interfaz con el nombre definitivo
                greetingMessage = " Bienvenido, $name"
                // forzamos la ocultación del teclado para mejorar la visibilidad del resultado
                keyboardController?.hide()
            },
            enabled = name.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Saludar")
        }

        // pintamos el mensaje resultante o la instrucción inicial apoyándonos en la tipografía del sistema
        Text(
            text = greetingMessage,
            style = MaterialTheme.typography.titleMedium
        )
    }
}