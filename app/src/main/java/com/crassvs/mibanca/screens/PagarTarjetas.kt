package com.crassvs.mibanca.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.crassvs.mibanca.R


@Composable
fun PagarTarjetas(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /*Image(painter = painterResource(id = R.drawable.pagar_tarjeta) ,
            contentDescription = null)
        Text(text = "Pagar Tarjetas")
         */
        MostrarTarjeta()
    }
}

@Composable
fun TarjetaFrente() {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            Image(
                modifier = Modifier
                    .size(64.dp)
                ,
                painter = painterResource(id = R.drawable.ic_logo_banco),
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .size(64.dp)
                ,
                painter = painterResource(id = R.drawable.ic_visa),
                contentDescription = null)
        }
        Text(text = "123 456 7890",
            fontSize = 25.sp
            )
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Column {
                Text(text = "Tiltular")
                Text(text = "Ximena Trujillo Ibanez")
            }
            Column {
                Text(text = "Valida Hasta")
                Text(text = "12/28")
            }
        }
    }
}

@Composable
fun MostrarTarjeta() {
    var rotate by remember {
        mutableStateOf(false)
    }
    val rotar by animateFloatAsState(
        targetValue = if (rotate) 180f else 0f,
        animationSpec = tween(500)
    )

    Card(
        modifier = Modifier
            .height(220.dp)
            .fillMaxSize()
            .padding(10.dp)
            .graphicsLayer {
                rotationY = rotar
                cameraDistance = 8 * density
            }
            .clickable { rotate = !rotate },
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme
                .colorScheme.primary
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
    if (!rotate){
        TarjetaFrente()
    }else{
        TarjetaAtras(rotar)
    }
    }
}

@Composable
fun TarjetaAtras(rotar: Float) {
    Column {
        Divider(
            color = Color.Black,
            thickness = 50.dp
            )
        Text(
            text = "123",
            color = Color.Black,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .background(Color.White)
                .padding(10.dp)
                .graphicsLayer {
                    rotationY = rotar
                },
                textAlign = TextAlign.Right
        )
    }
}


