package com.devid_academy.salattracker.ui.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalendarCase(
    day: String,
    date: String
) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .background(Color.Transparent)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 10.dp),
            text = day,
            color = Color.Black,
            fontSize = 16.sp
        )
        Text(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp),
            text = date,
            color = Color.Black,
            fontSize = 16.sp
        )
    }
}