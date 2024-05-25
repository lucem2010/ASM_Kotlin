package com.example.lucdtph31250_asm1

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lucdtph31250_asm1.ui.theme.Lucdtph31250_asm1Theme

@Composable
fun Login(navController: NavController,onLoginSuccess: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(top = 30.dp),

            horizontalArrangement = Arrangement.SpaceAround

        ) {
            ShortHorizontalLine()
            logo()
            ShortHorizontalLine()

        }
        Text(
            "Hello !",
            fontSize = 24.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(top = 200.dp)
        )
        Text(
            "WELCOME BACK",
            fontSize = 30.sp,
            fontStyle = FontStyle.Normal,
            modifier = Modifier.padding(top = 50.dp)
        )
        TextFieldWithEmail()
        TextFieldWithPasswork()


        Text(
            "Forgot Password",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(top = 80.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center

        )

        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            ButtonLogin (){

                onLoginSuccess()
            }
        }

        SignUpButton(onClick = {
            // Xử lý khi người dùng nhấp vào nút đăng ký
            navController.navigate("Sign_up")
        })

    }
}


@Composable
fun SignUpButton(onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center), // Đảm bảo nút văn bản được căn giữa theo chiều ngang
        content = {
            Text(
                text = AnnotatedString("SIGN UP"),
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        }
    )
}


@Composable
fun ButtonLogin(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
        modifier = Modifier
            .width(300.dp)
            .padding(top = 30.dp)
            .height(50.dp)
    ) {
        Text("Log in")
    }
}




@Composable
fun TextFieldWithEmail() {
    var value by remember { mutableStateOf("") }

    TextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Enter text") },
        maxLines = 2,
        textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp)
    )
}



@Composable
fun TextFieldWithPasswork() {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Enter password") },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp),
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    imageVector = if (passwordVisible) Icons.Filled.Close else Icons.Default.Done,
                    contentDescription = if (passwordVisible) "Hide password" else "Show password"
                )
            }
        }
    )
}

@Composable
fun ShortHorizontalLine() {
    Canvas(
        modifier = Modifier
            .size(80.dp, 4.dp)
            .padding(top = 17.dp)
    ) {
        val paint = Paint().apply {
            color = Color.Black // Màu của đường line
            strokeWidth = 4f // Độ dày của đường line
        }
        val startX = 50f
        val startY = size.height / 2 // Điểm bắt đầu nằm ở giữa chiều cao của Canvas
        val endX = startX + 300f // Kết thúc cách bắt đầu 10 pixel
        val endY = size.height / 2 // Điểm kết thúc cũng nằm ở giữa chiều cao của Canvas

        drawLine(
            color = Color.Black, // Màu của đường line
            start = Offset(startX, startY),
            end = Offset(endX, endY),
            strokeWidth = 4f // Độ dày của đường line
        )
    }
}

@Composable
fun logo() {
    val imageModifier = Modifier
        .size(150.dp)
        .background(Color.White)
    Image(
        painter = painterResource(id = R.drawable.group),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = imageModifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreviewLogin() {
    Lucdtph31250_asm1Theme {

    }
}