package com.example.lucdtph31250_asm1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lucdtph31250_asm1.ui.theme.Lucdtph31250_asm1Theme

@Composable
fun Welcome(navController: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column (

            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)

        ){
            Text("MAKE YOUR",
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic,
                modifier = Modifier.padding(bottom = 20.dp))
            Text("HOME BEAUTIFUL",
                fontSize = 30.sp,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.padding(bottom = 20.dp))

            Text("The best simple place where you discover most wonderful furnitures and make your home beautiful",
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 20.dp)

            )

            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ){
                ButtonWelcome (){
                navController.navigate("login")
                }
            }




        }
    }
}

@Composable
fun ButtonWelcome(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
        modifier = Modifier
            .width(200.dp)
            .padding(top = 200.dp)

    ) {
        Text("Get Started")
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreviewWelcome() {
    Lucdtph31250_asm1Theme {

    }
}