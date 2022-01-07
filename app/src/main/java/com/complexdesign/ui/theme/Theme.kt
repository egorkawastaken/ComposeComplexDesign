package com.complexdesign.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController


private val Colors = lightColors(
    surface = DeepBlue,
    primary = ButtonBlue
)

@Composable
fun ComplexDesignTheme(
    content: @Composable() () -> Unit
) {
    MaterialTheme(
        colors = Colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(color = DeepBlue)

}