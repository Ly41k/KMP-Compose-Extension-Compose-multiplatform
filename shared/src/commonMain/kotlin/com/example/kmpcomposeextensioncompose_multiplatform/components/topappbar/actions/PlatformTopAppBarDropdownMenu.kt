package com.example.kmpcomposeextensioncompose_multiplatform.components.topappbar.actions

import androidx.compose.runtime.Composable

@Composable
internal expect fun PlatformTopAppBarDropdownMenu(
    isMenuShowed: Boolean,
    onDismissMenuRequest: () -> Unit
)
