package com.devid_academy.salattracker.ui.mainscreen

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devid_academy.salattracker.R
import com.devid_academy.salattracker.logic.data.dto.PrayerDTO

@Composable
fun PrayerItem(
    prayer: PrayerDTO,
    imageResId: Int,
    statusImageResId: Int,
    onClick: () -> Unit = {}
) {

    Card(
        modifier = Modifier
            .width(350.dp)
            .height(100.dp)
            .padding(8.dp)
            .clickable(onClick = onClick) ,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Image à gauche
            Image(
                painter = painterResource(imageResId),
                contentDescription = prayer.name,
                modifier = Modifier
                    .size(48.dp)
                    .padding(start = 12.dp)
            )

            // Texte centré
            Text(
                text = prayer.name,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 20.sp,

            )


            // Image à droite
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(100.dp)
                    .clip(obliqueLeftShape())
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(statusImageResId),
                    contentDescription = "",
                    modifier = Modifier.size(45.dp),
                )
            }
        }
    }
}

fun obliqueLeftShape(): GenericShape {
    return GenericShape { size, _ ->

        val width = size.width
        val height = size.height

        moveTo(40f, 0f)
        lineTo(width, 0f)
        lineTo(width, height)
        lineTo(0f, height)
        close()

        close()
    }
}


@Preview(showBackground = true)
@Composable
private fun PrayerItemPreview() {
    PrayerItem(
        prayer = PrayerDTO(
            id = 1L,
            name = "Fajr",
            order = 1,
            type = "Obligatory"),
        imageResId = R.drawable.salat_fajr,
        statusImageResId = R.drawable.status_alone
    )
}