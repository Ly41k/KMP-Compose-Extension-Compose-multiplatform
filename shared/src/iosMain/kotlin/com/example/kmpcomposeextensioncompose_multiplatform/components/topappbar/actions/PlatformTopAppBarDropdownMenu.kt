package com.example.kmpcomposeextensioncompose_multiplatform.components.topappbar.actions

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.kmpcomposeextensioncompose_multiplatform.SharedRes
import dev.icerock.moko.resources.compose.stringResource

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
            Text(text = stringResource(SharedRes.strings.first_option))
        }
        DropdownMenuItemIos(onClick = {}) {
            Text(text = stringResource(SharedRes.strings.second_option))
        }
    }
}
