package com.example.kmpcomposeextensioncompose_multiplatform

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.kmpcomposeextensioncompose_multiplatform.components.card.CardView
import com.example.kmpcomposeextensioncompose_multiplatform.components.topappbar.TopAppBarView
import com.example.kmpcomposeextensioncompose_multiplatform.repos.OrderRepository
import com.example.kmpcomposeextensioncompose_multiplatform.repos.OrderRepositoryImpl
import dev.icerock.moko.resources.compose.stringResource
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun App() {

    val orderRepository: OrderRepository = OrderRepositoryImpl()
    var isMenuShowed by remember { mutableStateOf(false) }

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(
            initialValue = BottomSheetValue.Collapsed,
            density = LocalDensity.current
        )
    )

    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBarView(
                isMenuShowed = isMenuShowed,
                onMoreButtonClick = { isMenuShowed = true },
                onDismissMenuRequest = { isMenuShowed = false }


            )
        },
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            Box(
                modifier = Modifier.fillMaxWidth().height(height = 250.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = stringResource(SharedRes.strings.bottom_sheet_content))
            }
        },
        sheetBackgroundColor = Color.LightGray,
        sheetPeekHeight = 0.dp
    ) {
        Box(modifier = Modifier.fillMaxSize().background(Color.LightGray)) {
            val orders = orderRepository.getMockOrderList()
            LazyColumn(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                itemsIndexed(items = orders) { index, item ->
                    val topMargin = 6.dp.takeIf { index == 0 } ?: 0.dp
                    val bottomMargin = 6.dp.takeIf { index == orders.lastIndex } ?: 0.dp
                    CardView(
                        modifier = Modifier.padding(top = topMargin, bottom = bottomMargin),
                        products = item.products,
                        onButtonClick = {
                            coroutineScope.launch {
                                if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                    bottomSheetScaffoldState.bottomSheetState.expand()
                                } else {
                                    bottomSheetScaffoldState.bottomSheetState.collapse()
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}