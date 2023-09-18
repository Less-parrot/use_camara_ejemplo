package com.example.aprendercamera

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.aprendercamera.ui.theme.AprenderCameraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(applicationContext = applicationContext)//llamamos a la funcion MainScreen y le pasamos el contexto de la aplicación
        }
    }
}

@Composable
fun MainScreen(applicationContext: Context) {
    AprenderCameraTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Red//color de fondo de la app
        ) {
    /*  podemos ajustar aqui donde quiere que se muestre la cámara, por ejemplo:
            Box(Modifier.fillMaxSize().padding(20.dp)) {
                CamPreview(applicationContext = applicationContext)//usamos la cámara
            }
        PD: ya sería de su elección jugar con esto
    */
            Box(Modifier.fillMaxSize()) {
                CamPreview(applicationContext = applicationContext)//usamos la cámara
            }
        }
    }
}


