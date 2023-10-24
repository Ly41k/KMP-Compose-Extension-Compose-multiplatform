package com.example.kmpcomposeextensioncompose_multiplatform.components.topappbar.actions

import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

import com.example.kmpcomposeextensioncompose_multiplatform.SharedRes
import dev.icerock.moko.resources.compose.stringResource


@Composable
internal actual fun PlatformTopAppBarDropdownMenu(
    isMenuShowed: Boolean,
    onDismissMenuRequest: () -> Unit
) {
    DropdownMenu(expanded = isMenuShowed, onDismissRequest = onDismissMenuRequest) {
        DropdownMenuItem(onClick = { }) {
            Text(text = stringResource(SharedRes.strings.first_option))
        }
        DropdownMenuItem(onClick = { }) {
            Text(text = stringResource(SharedRes.strings.second_option))
        }
    }
}
