package com.oakil.fooddeliveryapplication.ui.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oakil.fooddeliveryapplication.R
import com.oakil.fooddeliveryapplication.ui.theme.Orange

@Composable
fun AuthScreen() {
    val imageSize = remember {
        mutableStateOf(IntSize.Zero)
    }

    val brush = Brush.verticalGradient(
        colors = listOf(
            Color.Transparent, Color.Black
        ),
        startY = imageSize.value.height.toFloat() / 3
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier
                .onGloballyPositioned {
                    imageSize.value = it.size
                }
                .alpha(0.6f)
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(brush = brush)
        )

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier
                .align(
                    Alignment.TopEnd
                )
                .padding(8.dp)
        ) {
            Text(text = stringResource(R.string.skip), color = Orange)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 110.dp, start = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.welcome),
                color = Color.Black,
                fontSize = 50.sp,
                modifier = Modifier,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.app_name),
                color = Orange,
                fontSize = 50.sp,
                modifier = Modifier,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.foodhub_description),
                color = Color.DarkGray,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 16.dp),

            )

        }


    }

}


@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    AuthScreen()
}