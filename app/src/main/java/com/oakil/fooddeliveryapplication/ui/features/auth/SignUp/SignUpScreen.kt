package com.oakil.fooddeliveryapplication.ui.features.auth.SignUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.oakil.fooddeliveryapplication.R
import com.oakil.fooddeliveryapplication.ui.FoodHubTextField
import com.oakil.fooddeliveryapplication.ui.GroupSocialButtons
import com.oakil.fooddeliveryapplication.ui.theme.Orange

@Composable
fun SignUpScreen(viewModel: SignUpViewModel = hiltViewModel()) {

    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.ic_auth_bg),
            contentDescription = "auth bg",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.weight(1f))

           Text(text = stringResource(R.string.sign_up),
               fontWeight = FontWeight.Bold,
               fontSize = 35.sp, modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally))

            FoodHubTextField(
                value = name,
                onValueChange = {name = it},
                label = {
                    Text(stringResource(R.string.full_name))
                },
                modifier = Modifier.fillMaxWidth()
            )
            FoodHubTextField(
                value = email,
                onValueChange = {email = it},
                label = {
                    Text(stringResource(R.string.email))
                },
                modifier = Modifier.fillMaxWidth()
            )
            FoodHubTextField(
                value = password,
                onValueChange = {password = it },
                label = {
                    Text(text = stringResource(R.string.password))
                },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                trailingIcon = {
                    Image(painter = painterResource(R.drawable.ic_eye), contentDescription = null)
                }
            )
            Spacer(modifier.padding(top = 20.dp))
            Button(
                onClick = {},
                modifier = Modifier.height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Orange)
            ) {
                Text(
                    text = stringResource(R.string.sign_up),
                    modifier = Modifier.padding(horizontal = 32.dp)
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            TextButton(onClick = {}){
                Text(text = stringResource(R.string.already_have_account_login),
                    textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.size(16.dp))
            GroupSocialButtons(color = Color.Black, onFacebookClick = {}, onGoogleClick = {})
            Spacer(modifier = Modifier.padding(bottom = 80.dp))
        }
    }
}


@Preview
@Composable
fun PreviewsignUpScreen() {
    SignUpScreen()

}