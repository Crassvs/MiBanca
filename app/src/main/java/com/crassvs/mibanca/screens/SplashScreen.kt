package com.crassvs.mibanca.screens

import android.content.Intent
import android.util.Log
import android.view.animation.OvershootInterpolator
import android.window.SplashScreen
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.crassvs.mibanca.MainActivity
import com.crassvs.mibanca.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(){

    val context = LocalContext.current
    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        delay(1000L)
        scale.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(8f)
                        .getInterpolation(it)
                }
            )
        )
        val intent = Intent(
            context,
            MainActivity::class.java
        )
        context.startActivity(intent)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .scale(scale.value)
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_bancop),
            contentDescription = "Logo del Banco"
        )
        Text(
            text = "Bienvenido",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer

        )
        OutlinedButton(
            onClick = {
                Log.d("SplashScreen","Click hecho")
                val intent = Intent(
                    context,
                    MainActivity::class.java
                )
                context.startActivity(intent)
        })
        {
            Text(
                text = "Continuar",
                style = MaterialTheme.typography.bodyLarge,
                )
            
        }
    }

    
}