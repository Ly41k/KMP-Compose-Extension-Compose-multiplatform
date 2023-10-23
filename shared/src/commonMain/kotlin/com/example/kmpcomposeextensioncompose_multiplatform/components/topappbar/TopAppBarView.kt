package com.example.kmpcomposeextensioncompose_multiplatform.components.topappbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.kmpcomposeextensioncompose_multiplatform.MainRes
import com.example.kmpcomposeextensioncompose_multiplatform.components.topappbar.actions.PlatformTopAppBarDropdownMenu

@Composable
fun TopAppBarView(
    isMenuShowed: Boolean,
    onMoreButtonClick: () -> Unit,
    onDismissMenuRequest: () -> Unit
) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = MainRes.string.app_name)
            }
        },
        backgroundColor = Color.White,
        actions = {
            IconButton(onClick = onMoreButtonClick) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = MainRes.string.more)
            }
            PlatformTopAppBarDropdownMenu(
                isMenuShowed = isMenuShowed,
                onDismissMenuRequest = onDismissMenuRequest
            )
        }
    )
}
