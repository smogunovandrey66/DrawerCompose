package com.learnandroid.drawercompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.learnandroid.drawercompose.R
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open) {
        true
    }
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        ModalDrawer(
            drawerState = drawerState,
            drawerContent = {
                Column {
                    TextButton(onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Screens.SimpleScreen.value)
                    }
                    ) {
                        Text(text = stringResource(id = R.string.item1))
                    }
                    Button(onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Screens.ScreenDrawer.value)
                    }
                    ) {
                        Text(text = stringResource(id = R.string.item1))
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.Red)
                    ) {

                    }
                }
            }
        ) {

            NavHost(navController = navController, startDestination = Screens.SimpleScreen.value) {
                composable(Screens.SimpleScreen.value) {
                    SimpleScreen()
                }
                composable(Screens.ScreenDrawer.value) {
                    ScreenDrawer()
//                    SimpleScreen()
                }
            }
        }
    }
}