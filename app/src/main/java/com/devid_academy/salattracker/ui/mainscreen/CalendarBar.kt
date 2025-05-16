package com.devid_academy.salattracker.ui.mainscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.LaunchedEffect


@Composable
fun CalendarBar(
    selectedDate: LocalDate,
    onDateSelected: (LocalDate) -> Unit
) {
    val daysList = (0 until 30).map { LocalDate.now().minusDays(it.toLong()) }.reversed()
    val listState = rememberLazyListState()

    val today = LocalDate.now()
    val todayIndex = daysList.indexOfFirst { it == today }

    LaunchedEffect(Unit) {
        if (todayIndex != -1) {
            listState.scrollToItem(todayIndex)
        }
    }

    LazyRow(
        state = listState,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(daysList) { day ->
            CalendarCase(
                day = day.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.FRENCH),
                date = day.dayOfMonth.toString(),
                isSelected = day == selectedDate,
                onClick = { onDateSelected(day) }
            )
        }
    }
}