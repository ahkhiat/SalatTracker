package com.devid_academy.salattracker.logic.enum

import androidx.compose.ui.graphics.Color
import com.devid_academy.salattracker.R
import com.devid_academy.salattracker.ui.theme.StatusAloneColor
import com.devid_academy.salattracker.ui.theme.StatusGroupColor
import com.devid_academy.salattracker.ui.theme.StatusLateColor
import com.devid_academy.salattracker.ui.theme.StatusUndefinedColor
import com.devid_academy.salattracker.ui.theme.StatusUndoneColor

enum class PrayerStatusEnum {
    Done,
    Late,
    Group,
    Undone,
    Undefined,
    ;

    fun getImageResId(): Int {
        return when (this) {
            Done -> R.drawable.status_alone
            Late -> R.drawable.status_late
            Group -> R.drawable.status_group
            Undone -> R.drawable.status_undone
            Undefined -> R.drawable.status_undefined
        }
    }

    fun getColorResId(): Color {
        return when (this) {
            Done -> StatusAloneColor
            Late -> StatusLateColor
            Group -> StatusGroupColor
            Undone -> StatusUndoneColor
            Undefined -> StatusUndefinedColor
        }
    }



}