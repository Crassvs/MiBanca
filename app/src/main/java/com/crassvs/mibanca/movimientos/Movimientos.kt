package com.crassvs.mibanca.movimientos

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.EmojiEmotions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Ingresos(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(Icons.Outlined.EmojiEmotions,
            "Ingresos")
        Text(text = "Ingresos ",
            style = MaterialTheme.typography.titleLarge)
    }
}

@Composable
fun Egresos(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(Icons.Outlined.EmojiEmotions,
            "Egresos",)
        Text(text = "Egresos ",
            style = MaterialTheme.typography.titleLarge)
    }
}

@Composable
fun Todos(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(Icons.Outlined.EmojiEmotions,
            "Todos los Movimientos")
        Text(text = "Todos los Movimientos",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center)
    }
}