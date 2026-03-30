package com.example.tugasakhirmobileapp

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun Loginpage(navController: NavController = rememberNavController()) {
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
                style = TextStyle(fontSize = 40.sp, color = White,fontWeight = FontWeight.Bold),
                modifier = Modifier.offset(y = -140.dp))

            Column(modifier = Modifier
                .offset(y = 20.dp)) {
                Text(text = "Username", color = White, fontSize = 20.sp)
                val textstate = remember { mutableStateOf(TextFieldValue()) }
                OutlinedTextField(
                    modifier = Modifier.border(width = 3.dp, color = White),
                    value = textstate.value,
                    onValueChange = { textstate.value = it },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done // Change the Enter key to Done action
                    ),
                    placeholder = {
                        Icon(
                            painter = painterResource(id = R.drawable.lock2),
                            contentDescription = "Custom Icon",
                            modifier = Modifier.size(30.dp),
                            tint = Color.White
                        )
                    }, textStyle = TextStyle(color = Color.White, fontSize = 20.sp)
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(text = "Password", color = White, fontSize = 20.sp)
                val textstate2 = remember { mutableStateOf(TextFieldValue()) }
                OutlinedTextField(
                    modifier = Modifier.border(width = 3.dp, color = White),
                    value = textstate2.value,
                    onValueChange = { textstate2.value = it },
                    placeholder = {
                        Icon(
                            painter = painterResource(id = R.drawable.lock3),
                            contentDescription = "Custom Icon",
                            modifier = Modifier.size(30.dp),
                            tint = Color.White
                        )
                    }, textStyle = TextStyle(color = Color.White, fontSize = 20.sp),
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(30.dp))
                OutlinedButton(//////Belom ganti warna Kiri
                    modifier = Modifier
                        .height(60.dp)
                        .width(280.dp)
                        ,
                    shape = RoundedCornerShape(
                        topStart = 10.dp,
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp,
                        topEnd = 10.dp,
                    ),


                    border = BorderStroke(4.dp, White),
                    onClick = {navController.navigate("Homescreen")}) {
                    Text(
                        text = "Log In",
                        color = White,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .offset(y = 3.dp)// Ensure the text occupies the full size of the Box
                    )
                }
            }
        }
    }
}

