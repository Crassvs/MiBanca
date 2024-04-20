package com.crassvs.mibanca.models

import android.icu.text.CaseMap.Title
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.ui.graphics.vector.ImageVector
import com.crassvs.mibanca.navigation.NavScreen

sealed class Items_options_config (
    val icon : ImageVector,
    val title: String,
    val ruta : String
){
    object Item_config1 : Items_options_config(
        Icons.Outlined.DarkMode,
        "Apariecincia",
        NavScreen.ConfigurarApariencia.name
    )
    object Item_config2 : Items_options_config(
        Icons.Outlined.Notifications,
        "Notificaciones",
        NavScreen.ConfigurarNotificaciones.name
    )
}