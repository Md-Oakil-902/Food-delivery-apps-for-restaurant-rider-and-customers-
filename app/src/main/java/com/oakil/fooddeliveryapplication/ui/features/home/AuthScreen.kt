package com.oakil.fooddeliveryapplication.ui.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import com.oakil.fooddeliveryapplication.R

@Composable
fun AuthScreen() {
    val imageSize = remember {
        mutableStateOf(IntSize.Zero)
    }

    val brush = Brush.verticalGradient(
        colors = listOf(
            Color.Transparent, Color.Black
        ),
        startY = imageSize.value.height.toFloat()/3
    )

    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.onGloballyPositioned {
                imageSize.value = it.size
            }.alpha(0.6f))
        Box(modifier = Modifier.matchParentSize().background(brush = brush))
    }

}


@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    AuthScreen()
}