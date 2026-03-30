package com.example.tugasakhirmobileapp


import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true)
@Composable
fun LoginSign(navController: NavController = rememberNavController()) {
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.backgrond_2),
            contentDescription = "image",
            modifier = Modifier
                .fillMaxSize(), // Add padding if necessary
            contentScale = ContentScale.Crop // Use ContentScale.Crop
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .width(350.dp)
                .height(350.dp)
                .offset(y = -75.dp)
                .background(
                    color = Color(android.graphics.Color.parseColor("#226139")),
                    shape = RoundedCornerShape(
                        topStart = 10.dp,
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp,
                        topEnd = 10.dp
                    )
                )
        ) {
            Text(text = "Login",
                style = TextStyle(fontSize = 40.sp, color = White, fontWeight = FontWeight.Bold),
                modifier = Modifier.offset(y = -140.dp))
            Text( text = "Or",
                style = TextStyle(fontSize = 20.sp, color = White, fontWeight = FontWeight.Bold),
                modifier = Modifier.offset(y = 80.dp, x = -3.dp))

            Canvas(modifier = Modifier.fillMaxWidth()) {
                val startX = 90f
                val startY = 220f
                val endX = size.width - 580f
                val endY = 220f
                val strokeWidth = 10f
                drawLine(
                    start = Offset(startX, startY),
                    end = Offset(endX, endY),
                    color = Color.White, // Change line color as needed
                    strokeWidth = strokeWidth
                )
            }
            Canvas(modifier = Modifier.fillMaxWidth()) {
                val startX = 560f
                val startY = 220f
                val endX = size.width - 90f
                val endY = 220f
                val strokeWidth = 10f
                drawLine(
                    start = Offset(startX, startY),
                    end = Offset(endX, endY),
                    color = Color.White, // Change line color as needed
                    strokeWidth = strokeWidth
                )
            }

            Column(
                modifier = Modifier
                    .offset(y = 30.dp)
            ) {
                Button(//////Belom ganti warna Kiri
                    modifier = Modifier
                        .height(60.dp)
                        .width(300.dp)
                        .offset(y = -40.dp)
                        ,
                    shape = RoundedCornerShape(
                        topStart = 10.dp,
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp,
                        topEnd = 10.dp,
                    ),
                    border = BorderStroke(4.dp, White),
                    onClick = { navController.navigate("LoginPage")} ,
                    colors = ButtonDefaults.buttonColors(Color.White)){
                    Text(
                        text = "Log In",
                        color = Color(android.graphics.Color.parseColor("#226139")),
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .offset(y = 3.dp)// Ensure the text occupies the full size of the Box
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedButton(//////Belom ganti warna Kiri
                    modifier = Modifier
                        .height(60.dp)
                        .width(300.dp)
                        .offset(y = -40.dp),
                    shape = RoundedCornerShape(
                        topStart = 10.dp,
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp,
                        topEnd = 10.dp,
                    ),
                    border = BorderStroke(4.dp, White),
                    onClick = {navController.navigate("LoginPage")}) {
                    Text(
                        text = "Sign Up",
                        color = White,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .offset(y = 3.dp)// Ensure the text occupies the full size of the Box
                    )
                }
            }
            var textState by remember { mutableStateOf("") }
            OutlinedButton(//////Belom ganti warna Kiri
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .offset(y = 130.dp, x = -90.dp),

                shape = RoundedCornerShape(
                    topStart = 10.dp,
                    bottomEnd = 10.dp,
                    bottomStart = 10.dp,
                    topEnd = 10.dp,
                    ),
                border = BorderStroke(2.dp, Color.White),
                onClick = {
                    textState = "apple user@gmail.com"
                    navController.navigate("LoginPage")
                }) {
            }
            OutlinedButton(//////Belom ganti warna Kiri
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .offset(y = 130.dp),

                shape = RoundedCornerShape(
                    topStart = 10.dp,
                    bottomEnd = 10.dp,
                    bottomStart = 10.dp,
                    topEnd = 10.dp,
                ),
                border = BorderStroke(2.dp, Color.White),
                onClick = { /*TODO*/ }) {

            }
            OutlinedButton(//////Belom ganti warna Kiri
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .offset(y = 130.dp, x = 90.dp),

                shape = RoundedCornerShape(
                    topStart = 10.dp,
                    bottomEnd = 10.dp,
                    bottomStart = 10.dp,
                    topEnd = 10.dp,
                ),
                border = BorderStroke(2.dp, Color.White),
                onClick = { /*TODO*/ }) {

            }
            Row(horizontalArrangement = Arrangement.Center,
                modifier = Modifier.offset(y = 130.dp)){
                Icon(
                    painter = painterResource(id = R.drawable.apple),
                    contentDescription = "Custom Icon",
                    modifier = Modifier.size(50.dp),
                    tint = Color.White)
                Spacer(modifier = Modifier.width(40.dp))
                Icon(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Custom Icon",
                    modifier = Modifier.size(50.dp),
                    tint = Color.White)
                Spacer(modifier = Modifier.width(40.dp))
                Icon(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "Custom Icon",
                    modifier = Modifier.size(50.dp),
                    tint = Color.White)

            }
        }
    }
}


