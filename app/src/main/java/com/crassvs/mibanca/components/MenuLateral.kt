package com.crassvs.mibanca.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.crassvs.mibanca.R
import com.crassvs.mibanca.models.Items_menu_lateral
import com.crassvs.mibanca.navigation.currentRoute
import kotlinx.coroutines.launch

@Composable
fun MenuLateral(
    navController: NavController,
    drawerState: DrawerState,
    contenido : @Composable () -> Unit
){
    val scope = rememberCoroutineScope()
    val menu_items = listOf(
        Items_menu_lateral.Items_menu_lateral1,
        Items_menu_lateral.Items_menu_lateral2,
        Items_menu_lateral.Items_menu_lateral3,
        Items_menu_lateral.Items_menu_lateral4,
    )
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Image(
                    painter = painterResource(id = R.drawable.ic_banco1),
                    contentDescription = null)
                menu_items.forEach { item ->
                    NavigationDrawerItem(
                        modifier = Modifier
                            .padding(10.dp),
                        icon = {
                            Icon(item.icon, contentDescription =null)
                        },
                        label = { Text(text = item.title) },
                        selected = currentRoute(navController) == item.ruta,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                            }
                            navController.navigate(item.ruta)
                        }
                    )
                }
            }
        }
    ){
        contenido()
    }
}