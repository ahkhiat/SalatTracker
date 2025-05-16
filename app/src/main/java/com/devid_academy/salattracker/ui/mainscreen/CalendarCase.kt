package com.devid_academy.salattracker.ui.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@Composable
//fun CalendarCase(
//    day: String,
//    date: String
//) {
//    Box(
//        modifier = Modifier
//            .size(60.dp)
//            .background(Color.Transparent)
//    ) {
//        Text(
//            modifier = Modifier
//                .align(Alignment.TopCenter)
//                .padding(top = 10.dp),
//            text = day,
//            color = Color.Black,
//            fontSize = 16.sp
//        )
//        Text(
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .padding(bottom = 10.dp),
//            text = date,
//            color = Color.Black,
//            fontSize = 16.sp
//        )
//    }
//}

@Composable
fun CalendarCase(
    day: String,
    date: String,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) Color(0xFF4CAF50) else Color.LightGray
    val textColor = if (isSelected) Color.White else Color.Black

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp, horizontal = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = day, color = textColor)
        Text(text = date, color = textColor, fontWeight = FontWeight.Bold)
    }
}