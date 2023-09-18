package com.example.aprendercamera

import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ujizin.camposer.CameraPreview
import com.ujizin.camposer.state.CamSelector
import com.ujizin.camposer.state.rememberCamSelector

@Composable
fun CamPreview(applicationContext: Context) {
    var CamSelector by rememberCamSelector(CamSelector.Front)//CamSelector.Back
    //recordamos el permiso de la cámara
    var hasCameraPermission by remember { mutableStateOf(false) }
    //mostramos mensaje emergente pideiendo el permiso a la cámara
    val requestCameraPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ){
        isGranted: Boolean ->
            hasCameraPermission = isGranted
    }

    //simulamos la petición del permiso(para pedirlo a lo que se abre la app)
    LaunchedEffect(Unit){
        requestCameraPermissionLauncher.launch(android.Manifest.permission.CAMERA)
    }
    //mostramos la cámara si se concede el permiso
    if (hasCameraPermission) {//permiso cámara concedido
        Box(Modifier.fillMaxSize()) {
            CameraPreview(camSelector = CamSelector)//mostrar cámara
        }
    }else {//permiso no concedido
        Text(
            text = "PERMISO NO CONCEDIDO",//Texto que indica de que no se consedio el permiso
            color = Color.Blue,//color del texto
            fontSize = 30.sp,//tamaño de fuente
            fontWeight = FontWeight.Bold//le damos más grosor al texto
        )
        //mensaje emergente de que no se concedio el permiso
        Toast.makeText(applicationContext, "PERMISO NO CONCEDIDO", Toast.LENGTH_SHORT).show()
    }

}