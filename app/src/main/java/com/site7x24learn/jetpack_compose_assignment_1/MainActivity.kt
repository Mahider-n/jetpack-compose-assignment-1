package com.site7x24learn.jetpack_compose_assignment_1

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.site7x24learn.jetpack_compose_assignment_1.data.model.Course

import com.site7x24learn.jetpack_compose_assignment_1.data.model.sampleCourses
import com.site7x24learn.jetpack_compose_assignment_1.ui.components.CourseCard
import com.site7x24learn.jetpack_compose_assignment_1.ui.screens.CourseListScreen
import com.site7x24learn.jetpack_compose_assignment_1.ui.theme.Jetpackcomposeassignment1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jetpackcomposeassignment1Theme(
                ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseListScreen(courses = sampleCourses)
                }
            }
        }
    }

}

// previews for night mode
@Preview(showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun CourseCardPreview() {
    Jetpackcomposeassignment1Theme(darkTheme = true, dynamicColor = false) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.padding(16.dp).padding(top = 10.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                var isExpanded1 by rememberSaveable { mutableStateOf(false) }
                var isExpanded2 by rememberSaveable { mutableStateOf(false) }

                // First card
                CourseCard(
                    course = Course(
                        id = "MD001",
                        title = "Mobile Development",
                        code = "CS402",
                        credits = 4,
                        description = "Learn to build Android apps with Jetpack Compose",
                        prerequisites = listOf("CS201", "CS301")
                    ),
                    isExpanded = isExpanded1,
                    onExpandedChange = { isExpanded1 = it }
                )

                // Second card
                CourseCard(
                    course = Course(
                        id = "DS002",
                        title = "Data Structures",
                        code = "CS201",
                        credits = 3,
                        description = "Introduction to fundamental data structures",
                        prerequisites = listOf("CS101")
                    ),
                    isExpanded = isExpanded2,
                    onExpandedChange = { isExpanded2 = it }
                )
            }
        }
    }
}
// previews for expanded view
@Preview(showBackground = true, name = "Expanded Card")
@Composable
fun ExpandedCourseCardPreview() {
    Jetpackcomposeassignment1Theme {
        CourseCard(
            course = Course(
                id = "C002",
                title = "Flutter",
                code = "COMP-202",
                credits = 4,
                description = "Deep dive into state hoisting and state management",
                prerequisites = listOf("COMP-101", "Kotlin Coroutines")
            ),
            isExpanded = true,
            onExpandedChange = {}
        )
    }
}