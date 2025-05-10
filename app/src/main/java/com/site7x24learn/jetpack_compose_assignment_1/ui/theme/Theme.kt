package com.site7x24learn.jetpack_compose_assignment_1.ui.theme

// Theme.kt
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

 // Light theme colors
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF006A6A),
    secondary = Color(0xFF4A6363),
    tertiary = Color(0xFFB45300),
    surface = Color(0xFFFFFBFE),
    surfaceVariant = Color(0xFFE0E3E3),
    onSurface = Color(0xFF1C1B1F),
     onSurfaceVariant = Color(0xFF5A5A5A),
    background = Color(0xFFFFFBFE)
)

// Dark theme colors
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF4ED8D8),
    secondary = Color(0xFFB4C8C8),
    tertiary = Color(0xFFFFB77C),
    surface = Color(0xFF1C1B1F),
    onSurface = Color(0xFFE6E1E5),
    background = Color(0xFF1C1B1F),
    surfaceVariant = Color(0xFF424242),
    onSurfaceVariant = Color(0xFFEEEEEE)
)

@Composable
fun Jetpackcomposeassignment1Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
