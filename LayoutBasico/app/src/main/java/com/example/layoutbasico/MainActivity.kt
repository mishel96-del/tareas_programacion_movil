package com.example.layoutbasico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.layoutbasico.ui.theme.LayoutBasicoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutBase4()
        }
    }
}

@Composable
fun LayoutBase4(){
    Box(modifier=Modifier.fillMaxSize()){

        Text(text="Sale lol?", modifier=Modifier.align(Alignment.TopStart))

        Image(
            painter = painterResource(id = R.drawable.janedoe),
            contentDescription = "MI VIEJA WEEEEEEEEEEEEE",
            modifier=Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun LayoutBase3(){
    Column(){
        Spacer(modifier=Modifier.height(30.dp))
        Row{
            Text(text="Texto en Fila")
            Spacer(modifier=Modifier.width(30.dp))
            Text(text="Texto en Fila")
        }

        Column(modifier = Modifier.fillMaxSize().padding(top=50.dp)){
            Text(text="Texto 1")
            Text(text="Texto 2")
        }
    }

}

@Composable
fun LayoutBase2(){
    Column(modifier = Modifier.fillMaxSize().padding(top=50.dp)){

        Row{
            Text(text="Texto en Fila")
            Spacer(modifier=Modifier.width(30.dp))
            Text(text="Texto en Fila")
        }

        Spacer(modifier=Modifier.height(30.dp))

        Text(text="Texto 1")
        Text(text="Texto 2")
    }
}

@Composable
fun LayoutBase1(){
    Row{
        Text(text="Texto en Fila")
        Spacer(modifier=Modifier.width(30.dp))
        Text(text="Texto en Fila")
    }

    Column(modifier = Modifier.fillMaxSize().padding(top=50.dp)){
        Text(text="Texto 1")
        Spacer(modifier=Modifier.height(30.dp))
        Text(text="Texto 2")
    }

}

@Composable
fun LayoutBase(){
    /**
    Row(modifier = Modifier.fillMaxSize().padding(top = 75.dp)){
        Text(text="---------------------------")
        Text(text="VVVVVVVVVVVVVVVVVVVVVVVVVVV")
    }
    **/

    Column(modifier = Modifier.fillMaxSize().padding(top = 25.dp)){
        Text(text="Hola Mundo :v")
        Text(text="Kotlin")
        Row(){
            Text(text="---------------------------")
            Text(text="VVVVVVVVVVVVVVVVVVVVVVVVVVV")
        }

    }
}

@Composable
@Preview (showBackground = true)
fun LayoutPreview(){
    LayoutBase4()
}