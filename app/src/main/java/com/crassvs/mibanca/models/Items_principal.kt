package com.crassvs.mibanca.models

sealed class Items_principal(
    var image: Int?,
    var title: String,
    var details: String
) {
    object Item_principal1: Items_principal(
        null,
        "Cuentas",
        "Detalle de Cuenta 1"
    )

    object Item_principal2: Items_principal(
        null,
        "Tarjetas de Crédito",
        "Dettale de Tarjeta 1"
    )

    object Item_principal3: Items_principal(
        null,
        "Recompensas",
        "Detalle Recompensas"
    )

    object Item_principal4: Items_principal(
        null,
        "Inversiones",
        "Detalles de Inversion 1"
    )

    object Item_principal5: Items_principal(
        null,
        "Créditos",
        "Detalle de Crédito 1"

    )
}