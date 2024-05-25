package com.example.lucdtph31250_asm1

import android.telecom.Call.Details
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lucdtph31250_asm1.ui.theme.Lucdtph31250_asm1Theme


    @Composable
    fun Detail(navController: NavController) {
        val product = remember {
            navController.currentBackStackEntry?.arguments?.getParcelable<Product>("product")
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(10.dp)
        ) {

            val imageModifier = Modifier
                .width(300.dp)
                .height(400.dp)
                .align(AbsoluteAlignment.TopRight)
            Image(
                painter = painterResource(id = R.drawable.groupa),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = imageModifier
            )

            Box(
                modifier = Modifier
                    .fillMaxSize(),
                
            ) {

                Column(
                    modifier = Modifier
                        .height(200.dp)
                        .width(80.dp)
                        .background(Color.White)
                        .border(4.dp, Color.Black, shape = RoundedCornerShape(20.dp)),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Circle(Color.Gray)
                    Circle(Color.Blue)
                    Circle(Color.Green)
                }
            }
        }
    }


@Composable
fun Circle(color: Color) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .background(color, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "",
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewDetail() {
    Lucdtph31250_asm1Theme {
        val navController = rememberNavController()
        Detail(navController)
    }
}