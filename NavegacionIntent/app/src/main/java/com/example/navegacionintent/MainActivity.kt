package com.example.navegacionintent

import android.content.Intent
import android.os.Bundle
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navegacionintent.MainActivity.Companion.FULL_NAME_KEY
import com.example.navegacionintent.ui.theme.NavegacionIntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacionIntentTheme {
                PantallaPrincipal()
            }
        }
    }
    /* companion object, es un objeto especial que pertenece a la clase, NO a una instancia
       usada para asignar y recuperar el nombre del usuario*/
    companion object {
        const val FULL_NAME_KEY = "FULL_NAME_KEY"
    }
}


@Composable
fun PantallaPrincipal(){
    var nombreApellidos by remember { mutableStateOf("") }
    val context = LocalContext.current
    val welcomeIntent =
        Intent(context, Actividad1::class.java)

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                value = nombreApellidos,
                onValueChange = { nombreApellidos = it },
                label = {
                    Text(
                        fontSize = 18.sp,
                        text = "Nombres y Apellidos"
                    )
                },
                textStyle = TextStyle(fontSize = 20.sp),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Button(
                onClick = ({
                    if (nombreApellidos.isNotEmpty()) {
                        welcomeIntent.putExtra(FULL_NAME_KEY, nombreApellidos)
                        context.startActivity(welcomeIntent)
                    } else {
                        Toast.makeText(
                            context, "Ingrese datos completos",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }),

                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "ACEPTAR")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaPrincipalPreview() {
    NavegacionIntentTheme {
        PantallaPrincipal()
    }
}
