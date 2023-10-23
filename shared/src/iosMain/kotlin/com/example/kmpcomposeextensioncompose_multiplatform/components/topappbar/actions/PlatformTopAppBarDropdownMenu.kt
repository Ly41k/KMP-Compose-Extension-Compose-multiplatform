package com.example.kmpcomposeextensioncompose_multiplatform.components.topappbar.actions

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.kmpcomposeextensioncompose_multiplatform.MainRes

@Composable
internal actual fun PlatformTopAppBarDropdownMenu(
    isMenuShowed: Boolean,
    onDismissMenuRequest: () -> Unit
) {
    DropdownMenuIos(
        expanded = isMenuShowed,
        onDismissRequest = onDismissMenuRequest
    ) {
        DropdownMenuItemIos(onClick = {}) {
            Text(text = MainRes.string.first_option)
        }
        DropdownMenuItemIos(onClick = {}) {
            Text(text = MainRes.string.second_option)
        }
    }
}
