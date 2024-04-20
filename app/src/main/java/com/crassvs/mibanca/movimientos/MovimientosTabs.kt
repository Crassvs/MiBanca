package com.crassvs.mibanca.movimientos

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.crassvs.mibanca.models.Items_tabs_movimientos
import com.crassvs.mibanca.models.Items_tabs_movimientos.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovimientosTabs(){
    val tabs = listOf(
        tab_Ingresos,
        tab_Egresos,
        tab_Todos
    )
    val pagerState = rememberPagerState(initialPage = 0) {3}

        Column {
            Tabs(tabs, pagerState)
            TabsContent(tabs,pagerState)
        }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabsContent(
    tabs: List<Items_tabs_movimientos>,
    pagerState: PagerState)
{
    HorizontalPager(
        state = pagerState,
        beyondBoundsPageCount = tabs.size
    ) {page ->
        tabs[page].screen()

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tabs(
    tabs: List<Items_tabs_movimientos>,
    pagerState: PagerState
    ) {
    var selectedTab = pagerState.currentPage
   TabRow(selectedTabIndex = selectedTab) {
       tabs.forEachIndexed{index, items ->
           Tab(
               selected = selectedTab == index,
               onClick = {/*TODO*/ },
               text = {Text(text = items.title)},
               icon = {
                  Icon(
                      if (index == selectedTab)
                          items.iconSelected
                      else
                          items.iconUnselected
                      ,
                      items.title)

               }
               )
       }
   }
}
