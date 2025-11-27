package com.example.ingresotexto

import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ingresotexto.ui.theme.IngresoTextoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IngresoTextoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaInicial(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PantallaInicial(modifier: Modifier) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        var nombre by remember { mutableStateOf("") }
        var apellido by remember { mutableStateOf("") }
        var identificacion by remember { mutableStateOf("") }

        val bienvenida = "Bienvenida"
        val msgerror = "Ingrese datos completos HDTPTM!!!!"

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = nombre,
                onValueChange = { nombre = it },
                label = {Text( text = "Nombres")}
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = apellido,
                onValueChange = { apellido = it },
                label = {Text(text = "Apellidos")}
            )
            val context = LocalContext.current
            Button(modifier = Modifier.fillMaxWidth(),
                onClick = {
                    if (
                        nombre.isNotBlank() &&
                        apellido.isNotBlank())
                        identificacion = "$nombre $apellido"
                    else {
                        identificacion = ""
                        val toast = Toast.makeText(
                            context,
                            msgerror,
                            Toast.LENGTH_LONG
                        )
                        toast.setGravity(Gravity.CENTER, 0, 0)
                        toast.show()
                    }
                }
            ) {
                Text("ACEPTAR")
            }
            if (identificacion.isNotBlank()) {
                Text(text = "$bienvenida $identificacion!")
            }
        }
    }

}

@Composable
@Preview (showBackground = true)
fun LayoutPreview(){
    PantallaInicial(modifier = Modifier.padding())
}