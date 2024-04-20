package com.crassvs.mibanca.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEmotions
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Score
import androidx.compose.material.icons.outlined.EmojiEmotions
import androidx.compose.material.icons.outlined.MonetizationOn
import androidx.compose.material.icons.outlined.Score
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.crassvs.mibanca.movimientos.Egresos
import com.crassvs.mibanca.movimientos.Ingresos
import com.crassvs.mibanca.movimientos.Todos

sealed class Items_tabs_movimientos (
    var title : String,
    var iconSelected : ImageVector,
    var iconUnselected : ImageVector,
    var screen : @Composable () -> Unit
){
    object tab_Ingresos : Items_tabs_movimientos(
        "Ingresos",
        Icons.Filled.EmojiEmotions,
        Icons.Outlined.EmojiEmotions,
        { Ingresos() }
    )

    object tab_Egresos : Items_tabs_movimientos(
        "Egresos",
        Icons.Filled.Score,
        Icons.Outlined.Score,
        { Egresos() }
    )

    object tab_Todos : Items_tabs_movimientos(
        "Todos los Movimientos",
        Icons.Filled.MonetizationOn,
        Icons.Outlined.MonetizationOn,
        { Todos() }
    )
}