package com.roblesdotdev.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HabitEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val category: String,
    val frequency: List<Int>,
    val completedDates: List<Long>,
    val reminder: Long,
    val startDate: Long,
)