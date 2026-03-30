package com.example.tugasakhirmobileapp

import android.content.Intent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun Myapp(navController: NavController = rememberNavController()) {

    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.backgroundadatopi),
            contentDescription = "image",
            modifier = Modifier
                .size(2000.dp)
                .matchParentSize(),
            contentScale = ContentScale.FillBounds
        )
        OutlinedButton(//////Belom ganti warna Kiri
            modifier = Modifier
                .height(60.dp)
                .width(200.dp)
                .offset(y = 240.dp)
                .background(
                    color = Color(android.graphics.Color.parseColor("#226139")),
                ),
            shape = RoundedCornerShape(
                topStart = 10.dp,
                bottomEnd = 10.dp,
                bottomStart = 10.dp,
                topEnd = 10.dp,
            ),
            border = BorderStroke(4.dp, Color.White),
            onClick = { /*TODO*/ }) {
            Text(
                text = "Update",
                color = Color.White,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .offset(y = 4.dp)// Ensure the text occupies the full size of the Box
            )
        }

        Box(
            modifier = Modifier
                .background(
                    color = Color.Black.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(
                        topStart = 10.dp,
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp,
                        topEnd = 10.dp,
                    )
                )
                .width(350.dp)
                .height(350.dp)
        ) {
            IconButton(modifier = Modifier
                .size(130.dp)
                .offset(x = 30.dp, y = 40.dp)
                ,onClick = {navController.navigate("Graph2")}) {
                Circularprogress(percentage =0.2f , number = 100 )

            }
            IconButton(modifier = Modifier
                .size(130.dp)
                .offset(x = 195.dp, y = 40.dp)
                ,onClick = {navController.navigate("Graph3")}) {
                Circularprogress(percentage =0.6f , number = 100 )

            }
            IconButton(modifier = Modifier
                .size(130.dp)
                .offset(x = 113.dp, y = 210.dp)
                ,onClick = {navController.navigate("Graph1")}) {

                Circularprogress(percentage =0.3f , number = 100 )

            }
            Text(
                text = "Soil Moisture",
                color = Color.Black,
                fontSize = 25.sp,
                modifier = Modifier
                    .offset(x = 20.dp, y = 5.dp)
            )
            Text(
                text = "Air Humidity",
                color = Color.Black,
                fontSize = 25.sp,
                modifier = Modifier
                    .offset(x = 190.dp, y = 5.dp)
            )
            Text(
                text = "Temperature",
                color = Color.Black,
                fontSize = 25.sp,
                modifier = Modifier
                    .offset(x = 110.dp, y = 170.dp)
            )
        }
    }
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text = "Farm Bot",
            fontSize = 40.sp,
            color = Color.White,
            modifier = Modifier
                .padding(16.dp) // Adjust padding as needed
                .offset(x = 0.dp, y = 20.dp)
        )// Adjust offset as needed(Nanti mau tambahin font
        Image(
            painter = painterResource(id = R.drawable.tomat2),
            contentDescription = "image",
            modifier = Modifier
                .size(66.dp) // Adjust size here
                .width(100.dp)
                .offset(x = -142.dp, y = 30.dp)
        )
        OutlinedButton(//////Belom ganti warna Kiri
            modifier = Modifier
                .height(75.dp)
                .width(75.dp)
                .offset(x = -140.dp, y = 27.dp),

            shape = RoundedCornerShape(
                topStart = 10.dp,
                bottomEnd = 10.dp,
                bottomStart = 10.dp,
                topEnd = 10.dp,

                ),
            border = BorderStroke(2.dp, Color.White),
            onClick = { navController.navigate("LoginSign")}) {

        }
        OutlinedButton(
            onClick = { /* onClick action */ },
            modifier = Modifier
                .padding(16.dp)
                .height(98.dp)
                .width(100.dp)
                .offset(x = 140.dp, y = 0.dp)
                .padding(13.dp),
            shape = RoundedCornerShape(
                topStart = 10.dp,
                bottomEnd = 10.dp,
                bottomStart = 10.dp,
                topEnd = 10.dp
            ),
            border = BorderStroke(2.dp, Color.White) // Menambahkan properti border
        ) {

            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .offset(x = 0.dp, y = -17.dp)
            ) {
                drawCircle(color = Color.White, radius = 30f)
            }

            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .offset(x = 0.dp, y = -10.dp)
            ) {
                drawRoundRect(
                    color = Color.White,
                    topLeft = Offset(-75f, 100f),
                    size = Size(80f, 80f),
                    cornerRadius = CornerRadius(1000f, 2000f) // Convert corner radius to pixels
                )
            }
        }
    }
}





@Composable
fun Circularprogress (
    percentage: Float,
    number : Int,
    fontsize: TextUnit = 50.sp,
    radius : Dp = 100.dp,
    color : Color = Color.Yellow,
    strokeWidth: Dp = 30.dp,
    animDuration : Int = 1000,
    animDelay : Int = 0


) {

    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val curpresentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        ), label = ""
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius * 2f)
    ) {
        Canvas(
            modifier = Modifier.size(radius * 2f)
        ) {
            drawArc(
                color = color,
                -90f,
                360 * curpresentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(
            text = (curpresentage.value * number).toInt().toString(),
            color = Color.Black,
            fontSize = fontsize,
            fontWeight = FontWeight.Bold

        )
    }
}
