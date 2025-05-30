package com.oakil.fooddeliveryapplication

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.animation.addListener
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.oakil.fooddeliveryapplication.Data.FoodApi
import com.oakil.fooddeliveryapplication.ui.features.auth.SignUp.AuthScreen
import com.oakil.fooddeliveryapplication.ui.features.auth.SignUp.SignUpScreen
import com.oakil.fooddeliveryapplication.ui.theme.FoodDeliveryApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    var showSplashScreen = true

    @Inject
    lateinit var foodApi: FoodApi

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                showSplashScreen
            }
            setOnExitAnimationListener { screen ->
                val zoomx = ObjectAnimator.ofFloat(screen.iconView, View.SCALE_X, 0.5f, 0f)
                val zoomY = ObjectAnimator.ofFloat(screen.iconView, View.SCALE_Y, 0.5f, 0f)

                val animatorSet = AnimatorSet().apply {
                    playTogether(zoomx, zoomY)
                    duration = 500
                    interpolator = OvershootInterpolator()
                    addListener(onEnd = {
                        screen.remove()
                    })

                }
                animatorSet.start()

            }
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
                FoodDeliveryApplicationTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding))
                        SignUpScreen()
                    }
                }
            }

            if (::foodApi.isInitialized) {
                Log.d("MainActivity", "FoodApi initialized")
            }

            CoroutineScope(Dispatchers.IO).launch {

                delay(3000)
                showSplashScreen = false
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        FoodDeliveryApplicationTheme {
            AuthScreen()
        }
    }
}