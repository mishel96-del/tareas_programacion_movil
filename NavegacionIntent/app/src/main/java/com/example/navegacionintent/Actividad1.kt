package com.example.navegacionintent

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navegacionintent.MainActivity.Companion.FULL_NAME_KEY
import com.example.navegacionintent.ui.theme.NavegacionIntentTheme

class Actividad1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacionIntentTheme {
                PantallaSecundaria(intent)
            }
        }
    }
}


@Composable
private fun PantallaSecundaria(intent: Intent) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding -> Box( contentAlignment =
        Alignment.Center,
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
    ) {
        val identificacion =
            intent.getStringExtra(
                FULL_NAME_KEY
            ) ?: ""
        val textSaludo = "Hola $identificacion Bienvenido"

        Text(
            textAlign = TextAlign.Center,
            text = textSaludo,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(12.dp)
        )
    }
    }
}


