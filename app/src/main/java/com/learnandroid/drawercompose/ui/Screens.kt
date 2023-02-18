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
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.LayoutDirection
import com.learnandroid.drawercompose.R
import kotlinx.coroutines.launch

enum class Screens(val value: String){
    SimpleScreen("SimpleScreen"),
    ScreenDrawer("ScreenDrawer")
}

@Composable
fun SimpleScreen() {
    Text(text = "Simple Screen")
}

@Composable
fun ScreenDrawer() {
    val drawerState  = rememberDrawerState(initialValue = DrawerValue.Open)
    val coroutineScope = rememberCoroutineScope()
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        ModalDrawer(
            drawerState = drawerState,
            drawerContent = {
                Column {
                    TextButton(onClick = { coroutineScope.launch { drawerState.close() } }) {
                        Text(text = stringResource(id = R.string.item2))
                    }
                    Button(onClick = { coroutineScope.launch { drawerState.close() } }) {
                        Text(text = stringResource(id = R.string.item2))
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

        }
    }
}