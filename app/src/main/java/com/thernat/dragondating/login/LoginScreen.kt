package com.thernat.dragondating.login

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thernat.dragondating.R
import com.thernat.dragondating.ui.theme.DragonBackground
import kotlinx.coroutines.launch
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun LoginScreen(onStartClick: () -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = DragonBackground
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)
            .then(Modifier.padding(all = 16.dp)),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Find Dragons",
                color = Color.White,
                fontSize = 24.sp
            )
            DatingCircle()
            Button(
                onClick = { onStartClick() },
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
            ) {
                Text(text = "Start")
            }
        }
    }
}

@Composable
private fun DatingCircle() {
    val logoImage = ImageBitmap.imageResource(id = R.drawable.backgrounddragon)
    val markPhotoBrush =
        ShaderBrush(ImageShader(ImageBitmap.imageResource(id = R.drawable.mark)))
    val rotateAngle = remember {
        Animatable(0f)
    }
    LaunchedEffect(rotateAngle) {
        launch {
            rotateAngle.animateTo(
                720f,
                animationSpec = infiniteRepeatable(tween(13000, easing = LinearEasing))
            )
        }
    }
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 240.dp)
    ) {
        val bigRadius = size.width /2.5f
        val angles = doubleArrayOf( 0.0,180.0,360.0)
        drawCircle(
            color = Color.White,
            radius = bigRadius
        )
        angles.forEach { angle ->
            rotate(rotateAngle.value) {
                drawCircle(
                    color = Color.White,
                    radius = size.width / 8,
                    center = Offset(
                        x = center.x + bigRadius * cos(angle).toFloat(),
                        y = center.y + bigRadius * sin(angle).toFloat()
                    )
                )
                drawImage(
                    image = logoImage,
                    topLeft = Offset(
                        x = center.x + bigRadius * cos(angle).toFloat() - logoImage.width / 2,
                        y = center.y + bigRadius * sin(angle).toFloat() - logoImage.height / 2
                    )
                )
            }
        }
    }
    Canvas(onDraw = {
        drawCircle(markPhotoBrush)
    }, modifier = Modifier.size(200.dp))
}
