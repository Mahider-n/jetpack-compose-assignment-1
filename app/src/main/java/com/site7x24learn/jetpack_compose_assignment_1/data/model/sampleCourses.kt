package com.site7x24learn.jetpack_compose_assignment_1.data.model

val sampleCourses = listOf(
    Course(
        id = "MD001",
        title = "Mobile Development",
        code = "CS402",
        credits = 4,
        description = "Learn to build Android apps with Jetpack Compose.",
        prerequisites = listOf("CS201", "CS301")
    ),
    Course(
        id = "DS002",
        title = "Data Structures",
        code = "CS201",
        credits = 3,
        description = "Introduction to fundamental data structures.",
        prerequisites = listOf("CS101")
    )
)