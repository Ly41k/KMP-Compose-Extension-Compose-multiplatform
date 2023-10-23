package com.example.kmpcomposeextensioncompose_multiplatform.components.topappbar.actions

import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.kmpcomposeextensioncompose_multiplatform.MainRes

@Composable
internal actual fun PlatformTopAppBarDropdownMenu(
    isMenuShowed: Boolean,
    onDismissMenuRequest: () -> Unit
) {
    DropdownMenu(expanded = isMenuShowed, onDismissRequest = onDismissMenuRequest) {
        DropdownMenuItem(onClick = { }) {
            Text(text = MainRes.string.first_option)
        }
        DropdownMenuItem(onClick = { }) {
            Text(text = MainRes.string.second_option)
        }
    }
}
