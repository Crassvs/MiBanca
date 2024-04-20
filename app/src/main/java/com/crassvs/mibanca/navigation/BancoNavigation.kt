package com.crassvs.mibanca.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.crassvs.mibanca.screens.ConfigurarApariencia
import com.crassvs.mibanca.screens.ConfigurarNotificaciones
import com.crassvs.mibanca.screens.HomeScreen
import com.crassvs.mibanca.screens.PagarServicios
import com.crassvs.mibanca.screens.PagarTarjetas
import com.crassvs.mibanca.screens.Transferencias

@Composable
fun BancoNavigation(
    navController: NavHostController
){
    NavHost(navController = navController,
        startDestination = NavScreen.HomeScreen.name
    ){
        composable(NavScreen.HomeScreen.name){
            HomeScreen()
        }
        composable(NavScreen.Tranferencias.name){
            Transferencias()
        }
        composable(NavScreen.PagarTarjetas.name){
            PagarTarjetas()
        }
        composable(NavScreen.PagarServicios.name){
            PagarServicios()
        }
        composable(NavScreen.ConfigurarApariencia.name){
            ConfigurarApariencia()
        }
        composable(NavScreen.ConfigurarNotificaciones.name){
            ConfigurarNotificaciones()
        }
    }
}