package com.thernat.dragondating.data

import java.time.LocalDate

data class Dragon(
    val id: String,
    val name: String,
    val imageUrl: String,
    val dateOfBirth: LocalDate,
    val location: String,
    val bio: String,
    val interests: List<String>
)
