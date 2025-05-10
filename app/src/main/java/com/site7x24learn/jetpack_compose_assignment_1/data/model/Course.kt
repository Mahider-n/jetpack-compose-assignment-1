package com.site7x24learn.jetpack_compose_assignment_1.data.model

data class Course(
    val id: String,
    val title: String,
    val code: String,
    val credits: Int,
    val description: String,
    val prerequisites: List<String>
)