package com.oakil.fooddeliveryapplication.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oakil.fooddeliveryapplication.R
import com.oakil.fooddeliveryapplication.ui.theme.White

@Composable
fun GroupSocialButtons(
    onFacebookClick: () -> Unit,
    onGoogleClick: () -> Unit,
    color: Color = Color.White
) {
    Column(modifier = Modifier.padding(bottom = 16.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            HorizontalDivider(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp, end = 8.dp).align(alignment = Alignment.CenterVertically), thickness = 1.dp, color = color
            )
            Text(text = stringResource(R.string.sign_in_with), color = color, modifier = Modifier.align(Alignment.CenterVertically))
            HorizontalDivider(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp, start  = 8.dp).align(Alignment.CenterVertically), thickness = 1.dp, color = color
            )
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
            SocialButton(icon = R.drawable.ic_facebook, title = R.string.facebook, onFacebookClick)
            SocialButton(icon = R.drawable.ic_google, title = R.string.Google, onGoogleClick)
        }

    }

}


@Composable
fun SocialButton(icon: Int, title: Int, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = White),
        shape = RoundedCornerShape(32.dp)
    ) {
        Row(
            modifier = Modifier.padding(start = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = stringResource(title), color = Color.Black)
        }
    }


}


@Preview
@Composable
fun Grop() {
    GroupSocialButtons(
        onFacebookClick = TODO(),
        onGoogleClick = TODO(),
        color = TODO()
    )
}




