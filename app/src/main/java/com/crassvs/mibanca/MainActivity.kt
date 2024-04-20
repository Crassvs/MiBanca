package com.crassvs.mibanca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CardGiftcard
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.crassvs.mibanca.components.MenuLateral
import com.crassvs.mibanca.components.NavegacionInferior
import com.crassvs.mibanca.components.TopBar
import com.crassvs.mibanca.models.Items_options_config
import com.crassvs.mibanca.models.Items_options_config.*
import com.crassvs.mibanca.navigation.BancoNavigation
import com.crassvs.mibanca.screens.HomeScreen
import com.crassvs.mibanca.screens.SplashScreen
import com.crassvs.mibanca.ui.theme.MiBancaTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiBancaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed)
    MenuLateral(
        navController = navController,
        drawerState = drawerState
    ) {
        contenido(
            navController = navController,
            drawerState =  drawerState)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun contenido(
    navController : NavHostController,
    drawerState: DrawerState
){
    val  mainViewModel : MainViewModel = viewModel()
    val sheetState = rememberModalBottomSheetState()
    Scaffold(
        topBar = {
           TopBar(drawerState)
        },
        bottomBar = {
            NavegacionInferior(navController)
        }
    ) {padding->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ){
            BancoNavigation(navController = navController )
        }
        if (mainViewModel.showBottomSheet){
            ModalBottomSheet(onDismissRequest = { mainViewModel.showBottomSheet = false}
            ){
                ContentButtomSheet(
                    navController,
                    mainViewModel,
                    sheetState
                )
            }
        }
        if (mainViewModel.showDialogRecompensas)
            DialogoRecompensas(mainViewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentButtomSheet(
    navController: NavHostController,
    mainViewModel: MainViewModel,
    sheetState: SheetState
){
    val items_configuration = listOf(
        Item_config1,
        Item_config2
    )
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .padding(horizontal = 28.dp)
    ) {
        Text(text = "Configuración",
            style = MaterialTheme.typography.titleSmall
        )
        items_configuration.forEach { item->
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(48.dp)
                    .clickable {
                        scope
                            .launch {
                                sheetState.hide()
                            }
                            .invokeOnCompletion {
                                mainViewModel.showBottomSheet = false
                            }
                        navController.navigate(item.ruta)
                    }

            ){
                Icon(item.icon, item.title)
                Spacer(modifier = Modifier.width(24.dp))
                Text(text = item.title)
            }
        }
    }
}

@Composable
fun DialogoRecompensas(
    mainViewModel: MainViewModel
) {
    AlertDialog(
        icon = {
               Icon(
                   Icons.Outlined.CardGiftcard,
                   null,
                   modifier = Modifier
                       .size(48.dp)
               )
        },
        title = {
                Text(text = "Recompensas")
        },
        text = {
               Text(text = "Esta Sección Estará Disponible Pronto")
        },
        onDismissRequest = {
                           mainViewModel.showDialogRecompensas = false
        },
        confirmButton = {
            TextButton(onClick = {
                mainViewModel
                    .showDialogRecompensas = false
            }) {
                Text(text = "Cerrar")
            }
        })
}

@Composable
fun TopBar(
    mainViewModel : MainViewModel
){

}
