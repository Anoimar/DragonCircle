package com.thernat.dragondating.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thernat.dragondating.R

@Composable
fun HomeScreen() {
    val dragonMatches = mutableListOf("Kate", "John", "Anne", "Marko")
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Black
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .fillMaxHeight()) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 16.dp),
            ) {
                Text(
                    text = stringResource(R.string.matches),
                    color = Color.White,
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Italic
                )
            }
            val matchesListScrollState = rememberScrollState()
            LazyRow(modifier = Modifier.verticalScroll(matchesListScrollState)) {
                items(dragonMatches) { dragon ->
                    Text(text = dragon, color = Color.White)
                }
            }
        }
    }
}