package com.crassvs.mibanca.models

import android.icu.text.CaseMap.Title
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.PriceCheck
import androidx.compose.ui.graphics.vector.ImageVector
import com.crassvs.mibanca.navigation.NavScreen

sealed class Items_bottom_nav(
    val icon : ImageVector,
    val title: String,
    val route: String
){
    object Item_bottom_nav1: Items_bottom_nav(
        Icons.Outlined.AttachMoney,
        "Tranferencias",
        NavScreen.Tranferencias.name
    )

    object Item_bottom_nav2: Items_bottom_nav(
        Icons.Outlined.PriceCheck,
        "Pagar Servicios",
        NavScreen.PagarServicios.name
    )

    object Item_bottom_nav3: Items_bottom_nav(
        Icons.Outlined.CreditCard,
        "Pagar Tarjeta",
        NavScreen.PagarTarjetas.name
    )
}