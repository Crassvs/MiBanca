package com.crassvs.mibanca.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.PriceCheck
import androidx.compose.material.icons.outlined.RealEstateAgent
import androidx.compose.ui.graphics.vector.ImageVector
import com.crassvs.mibanca.navigation.NavScreen

sealed class Items_menu_lateral (
    val icon : ImageVector,
    val title : String,
    val ruta : String
){
    object Items_menu_lateral1 : Items_menu_lateral(
        Icons.Outlined.RealEstateAgent,
        "Consulta de Saldos",
        NavScreen.HomeScreen.name
    )

    object Items_menu_lateral2 : Items_menu_lateral(
        Icons.Outlined.CreditCard,
        "Pagar Tarjetas",
        NavScreen.PagarTarjetas.name
    )

    object Items_menu_lateral3 : Items_menu_lateral(
        Icons.Outlined.PriceCheck,
        "Pagar Servicios",
        NavScreen.PagarServicios.name
    )

    object Items_menu_lateral4 : Items_menu_lateral(
        Icons.Outlined.AttachMoney,
        "Tranferencias",
        NavScreen.Tranferencias.name
    )
}