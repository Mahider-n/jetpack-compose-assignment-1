package com.site7x24learn.jetpack_compose_assignment_1.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.site7x24learn.jetpack_compose_assignment_1.data.model.Course
import com.site7x24learn.jetpack_compose_assignment_1.ui.components.CourseCard


@Composable
fun CourseListScreen(courses: List<Course>) {
    val expandedCourseIds = rememberSaveable { mutableStateOf<Set<String>>(emptySet()) }

    LazyColumn(
        modifier = Modifier.padding(16.dp)
            .padding(top = 15.dp)
    ) {
        items(courses) { course ->
            val isExpanded = expandedCourseIds.value.contains(course.id)
            CourseCard(
                course = course,
                isExpanded = expandedCourseIds.value.contains(course.id),
                onExpandedChange = { expanded ->
                    expandedCourseIds.value = if (expanded) {
                        expandedCourseIds.value + course.id
                    } else {
                        expandedCourseIds.value - course.id
                    }
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}