package com.devid_academy.salattracker.ui.mainscreen


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.devid_academy.salattracker.R
import com.devid_academy.salattracker.logic.viewmodel.MainViewModel
import com.devid_academy.salattracker.ui.reusablecomponents.ScaffoldComposable
import org.koin.androidx.compose.koinViewModel
import com.devid_academy.salattracker.logic.data.dto.PrayerDTO
import com.devid_academy.salattracker.ui.mainscreen.CalendarCase
import com.devid_academy.salattracker.ui.mainscreen.PrayerItem
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun MainScreen(
    navController: NavController
) {

    val viewModel: MainViewModel = koinViewModel()
    val prayersList = viewModel.prayersList.collectAsState().value

    LaunchedEffect(prayersList) {
        Log.i("MAIN SCREEN", "MainScreen: $prayersList")
    }

    MainContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainContent() {
    val selectedDate = remember { mutableStateOf(LocalDate.now()) }

    val formatter = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy", Locale.FRANCE)
    val formattedDate = selectedDate.value.format(formatter).replaceFirstChar { it.uppercase() }

    ScaffoldComposable (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(
                    text = formattedDate
                ) }
            )
        },
        bottomBar = {
            BottomAppBar {
                Text("Ma BottomBar")
            }
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
//                LazyRow(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(8.dp)
//                ) {
//                    items(30) { index ->
//                        CalendarCase(
//                            day = "Lun",
//                            date = index.toString()
//                        )
//                    }
//                }
                CalendarBar(
                    selectedDate = selectedDate.value,
                    onDateSelected = { newDate ->
                        selectedDate.value = newDate
//                        viewModel.loadStatusesFromApi(newDate)
                    }
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    PrayerItem(
                        prayer = PrayerDTO(
                            id = 1L,
                            name = "Fajr",
                            order = 1,
                            type = "Obligatory"
                        ),
                        imageResId = R.drawable.salat_fajr, // exemple
                        statusImageResId = R.drawable.status_undefined // exemple
                    )
                    PrayerItem(
                        prayer = PrayerDTO(
                            id = 1L,
                            name = "Dhor",
                            order = 1,
                            type = "Obligatory"
                        ),
                        imageResId = R.drawable.salat_dhor, // exemple
                        statusImageResId = R.drawable.status_undefined // exemple
                    )
                    PrayerItem(
                        prayer = PrayerDTO(
                            id = 1L,
                            name = "Asr",
                            order = 1,
                            type = "Obligatory"
                        ),
                        imageResId = R.drawable.salat_asr, // exemple
                        statusImageResId = R.drawable.status_undefined // exemple
                    )
                    PrayerItem(
                        prayer = PrayerDTO(
                            id = 1L,
                            name = "Maghreb",
                            order = 1,
                            type = "Obligatory"
                        ),
                        imageResId = R.drawable.salat_maghreb, // exemple
                        statusImageResId = R.drawable.status_undefined // exemple
                    )
                    PrayerItem(
                        prayer = PrayerDTO(
                            id = 1L,
                            name = "Icha",
                            order = 1,
                            type = "Obligatory"
                        ),
                        imageResId = R.drawable.salat_icha, // exemple
                        statusImageResId = R.drawable.status_undefined // exemple
                    )
                }

            }

        }
    )
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    MainContent()
//    CalendarCase(
//        day = "Lun",
//        date = "12"
//    )
}