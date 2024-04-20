package com.crassvs.mibanca.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CardGiftcard
import androidx.compose.material.icons.outlined.LocalActivity
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.PhoneEnabled
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Web
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.crassvs.mibanca.MainViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    drawerState : DrawerState
){
    val mainViewModel : MainViewModel = viewModel()
    val scope = rememberCoroutineScope()
    var showMenu by remember{
        mutableStateOf(false)
    }
    CenterAlignedTopAppBar(
        title = { Text(text = "Hola") },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    drawerState.open()
                }
            }){
                Icon(
                    Icons.Outlined.Menu,
                    "Abrir Menú Lateral")
            }
        },
        actions = {
            IconButton(onClick = {
                mainViewModel
                    .showDialogRecompensas = true
            }) {
                Icon(Icons.Outlined.CardGiftcard,
                    "Ir a Recompensa")
            }
            IconButton(onClick = {
                mainViewModel.showBottomSheet = true
            }) {
                Icon(Icons.Outlined.Settings,
                    "Ir a Cofiguración")
            }
            IconButton(onClick = { showMenu = !showMenu}) {
                Icon(Icons.Outlined.MoreVert,
                    "Más Opciones")
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { /*TODO*/
                    showMenu = false
                }) {
                DropdownMenuItem(
                    leadingIcon = {
                                  Icon(Icons.Outlined.PhoneEnabled,
                                      "Línea de Ayuda")
                    },
                    text = { Text(text = "Línea Directa") },
                    onClick = { /*TODO*/ }
                )
                DropdownMenuItem(
                    leadingIcon = {
                        Icon(Icons.Outlined.Web,
                            "Sitio Web")
                    },
                    text = { Text(text = "Sitio Web") },
                    onClick = { /*TODO*/ }
                )
                DropdownMenuItem(
                    leadingIcon = {
                        Icon(Icons.Outlined.LocalActivity,
                            "Ubica una Sucursal")
                    },
                    text = { Text(text = "Ubica una Sucursal") },
                    onClick = { /*TODO*/ }
                )
            }
        }
    )
}