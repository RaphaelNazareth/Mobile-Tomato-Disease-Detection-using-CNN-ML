package com.example.tugasakhirmobileapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.graphics.Paint
import android.graphics.PointF
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Preview(showBackground = true)
@Composable
fun Graph3(navController: NavController = rememberNavController()) {

    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.backgroundadatopi),
            contentDescription = "image",
            modifier = Modifier
                .fillMaxSize(), // Add padding if necessary
            contentScale = ContentScale.Crop // Use ContentScale.Crop
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .width(380.dp)
                .height(280.dp)
                .offset(y = -80.dp)
                .background(
                    color = Color(android.graphics.Color.parseColor("#226139")),
                    shape = RoundedCornerShape(
                        topStart = 10.dp,
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp,
                        topEnd = 10.dp
                    )
                )
        ){Text(
            text = "Humidity By Hour",
            color = Color.White,
            fontSize = 25.sp,

            modifier = Modifier
                .fillMaxSize()
                .offset(y = 8.dp,x = 12.dp))

        }
        LineChart3()

        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .width(130.dp)
                .height(130.dp)
                .offset(y = 220.dp,x =100.dp)
        ){
            Text(
                text = "Humidity",
                color = Color.Black,
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .offset(y = -85.dp))
            Circularprogress3(percentage =0.2f , number = 100 )
        }
        OutlinedButton(//////Belom ganti warna Kiri
            modifier = Modifier
                .height(60.dp)
                .width(160.dp)
                .offset(y = 350.dp)
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
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .width(180.dp)
                .height(200.dp)
                .offset(y = 210.dp,x =-90.dp)
                .padding(0.dp)

        ){ScrollableText3()
            Text(
                text = "Tomatoes Fun Fact",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,

                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .offset(y = -30.dp,x = -2.dp))// Ensure the text occupies the full size of the Box
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
            onClick = {navController.navigate("Homescreen")}) {

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

private fun lineChartData1() = listOf(
    22,24,26,22,20,21,23,29,30,33,
)

@Composable
fun LineChart3() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(16.dp)
            .offset(y = -60.dp)

    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),

            ) {
            drawRect(
                color = Color.White, // Specify the color you want to use
                topLeft = Offset(0f, 0f), // Set the top-left corner of the rectangle
                size = Size(1000f, 900f) // Set the size of the rectangle
            )
            val chartWidth = size.width - -100 // Adjusted width to account for padding
            val chartHeight = size.height - 20 // Adjusted height to account for padding
            val distanceX = chartWidth / (lineChartData1().size + 1)
            val distanceY = chartHeight / (lineChartData1().maxOrNull() ?: 5)
            var currentX = 16F // Starting x position adjusted for padding
            chartHeight + 0F // Starting y position adjusted for padding
            val maxValue = lineChartData1().maxOrNull() ?: 0
            val points = mutableListOf<PointF>()

            // Drawing x-axis scope
            drawLine(
                start = Offset(30f, chartHeight),
                end = Offset(size.width - 50f, chartHeight),
                color = Color.Gray,
                strokeWidth = 3f
            )

            // Drawing y-axis scope
            drawLine(
                start = Offset(80f, 0f),
                end = Offset(80f, chartHeight),
                color = Color.Gray,
                strokeWidth = 3f
            )

            // Drawing x-axis scale
            for (i in 1..lineChartData1().size) {
                val xTick = 16f + i * distanceX
                drawLine(
                    start = Offset(xTick, chartHeight),
                    end = Offset(xTick, chartHeight + 8f),
                    color = Color.Black,
                    strokeWidth = 2f
                )
                drawIntoCanvas {
                    it.nativeCanvas.drawText(
                        i.toString(),
                        xTick - 8f,
                        chartHeight + 40f,
                        Paint().apply {
                            color = Color.Black.toArgb()
                            textSize = 30f
                        }
                    )
                }
            }

            // Drawing y-axis scale
            // Drawing y-axis scale
            val minValue2 = lineChartData1().minOrNull() ?: 0 // Get the minimum value from the data
            val yScalePoints = (minValue2..maxValue step ((maxValue - minValue2) / 5).coerceAtLeast(1)).toList() // Generate scale points
            for (i in yScalePoints) {
                val yTick = chartHeight - (i - minValue2) * distanceY // Adjust y-coordinate based on minimum value
                drawLine(
                    start = Offset(80f, yTick),
                    end = Offset(70f, yTick),
                    color = Color.Black,
                    strokeWidth = 2f
                )
                drawIntoCanvas {
                    it.nativeCanvas.drawText(
                        i.toString(),
                        20f,
                        yTick + 9f,
                        Paint().apply {
                            color = Color.Black.toArgb()
                            textSize = 30f
                        }
                    )
                }
            }


            // Find the minimum value of the data
            val minValue = lineChartData1().minOrNull() ?: 0

            lineChartData1().forEachIndexed { index, data ->
                if (lineChartData1().size >= index + 2) {
                    val y0 = chartHeight - (data - minValue) * distanceY  // Adjusted calculation for y-coordinate
                    val x0 = currentX + distanceX
                    points.add(PointF(x0, y0))
                    currentX += distanceX
                }
            }

            for (i in 0 until points.size - 1) {
                drawLine(
                    start = Offset(points[i].x, points[i].y),
                    end = Offset(points[i + 1].x, points[i + 1].y),
                    color = Color(0xFF0047AB),
                    strokeWidth = 4f
                )
            }
        }
    }
}

@Composable
fun Circularprogress3(
    percentage: Float,
    number: Int,
    fontsize: TextUnit = 50.sp,
    radius: Dp = 100.dp,
    hexColor: String = "#4eb0ff",
    strokeWidth: Dp = 20.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {
    // Convert hex color to Color
    val color = Color(android.graphics.Color.parseColor(hexColor))

    var animationPlayed by remember { mutableStateOf(false) }
    val curPercentage = animateFloatAsState(
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
                startAngle = -90f,
                sweepAngle = 360 * curPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(
            text = (curPercentage.value * number).toInt().toString(),
            color = Color.Black,
            fontSize = fontsize,
            fontWeight = FontWeight.Bold
        )
    }
}
@Composable
fun ScrollableText3() {
    // Create a ScrollState to keep track of the scroll position
    val scrollState = rememberScrollState()

    // Use a Column with verticalScroll modifier to enable scrolling
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(9.dp)
            .verticalScroll(scrollState) // Enable vertical scrolling
    ) {
        Text(
            text = "Did you know that tomato plants require specific humidity levels to thrive, which vary with environmental temperatures? The optimal humidity for tomato plants is between 60% and 80% when temperatures range from 16°C to 21°C. Maintaining the right humidity is crucial for the plant's health and productivity. Higher humidity can enhance fruit set, but it also increases the risk of disease due to reduced water evaporation from the leaves, leading to malnutrition. Conversely, if the humidity is too low, the plant may transpire excessive water, resulting in stress. Thus, achieving the right humidity balance is essential for the well-being of tomato plants.",
            color = Color.Black,
            fontSize = 15.sp,
            textAlign = TextAlign.Left,
            lineHeight = 20.sp,
            fontFamily = FontFamily.Default,
            modifier = Modifier
                .fillMaxWidth() // Ensure the text occupies the full width of the Column
        )
    }
}