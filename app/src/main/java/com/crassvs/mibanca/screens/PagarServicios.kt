package com.crassvs.mibanca.screens

import kotlin.random.Random.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crassvs.mibanca.R
import java.util.Random


@Composable
fun PagarServicios(){
    val iconos = listOf(
        "✈️","🚆","🎬",
        "🏆","🎪","🏥",
        "🪝", "🛸","🚗"

    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /*
        Image(painter = painterResource(id = R.drawable.pago_de_servicios) ,
            contentDescription = null)
        Text(text = "Pagar Servicios")

         */
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
        ) {
            items(iconos){iconos->
                Card (
                    modifier = Modifier
                        .padding(4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(
                            red = kotlin.random.Random.nextInt(0,255),
                            green = kotlin.random.Random.nextInt(0,255),
                            blue = kotlin.random.Random.nextInt(0,255)
                        )
                    )
                ){
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        fontSize = 42.sp,
                        textAlign = TextAlign.Center,
                        text = iconos)
                }

            }

        }
    }
}