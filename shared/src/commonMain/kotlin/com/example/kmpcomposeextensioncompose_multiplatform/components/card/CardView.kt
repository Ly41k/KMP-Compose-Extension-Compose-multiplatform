package com.example.kmpcomposeextensioncompose_multiplatform.components.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kmpcomposeextensioncompose_multiplatform.SharedRes
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun CardView(
    modifier: Modifier,
    products: List<ImageResource>,
    onButtonClick: () -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth().wrapContentWidth(),
        shape = RoundedCornerShape(20.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(SharedRes.strings.obtained),
                    fontWeight = FontWeight(500),
                    fontSize = 20.sp,
                    color = Color.Gray
                )
                Text(
                    text = stringResource(SharedRes.strings.repeat),
                    fontWeight = FontWeight(400),
                    fontSize = 13.sp,
                    color = Color.Blue
                )
            }

            Row(modifier = Modifier.fillMaxWidth().padding(top = 16.dp)) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(products) { product ->
                        Image(
                            painter = painterResource(product),
                            contentDescription = stringResource(SharedRes.strings.cd_product),
                            modifier = Modifier.size(56.dp)
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp, bottom = 18.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = onButtonClick,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                    contentPadding = PaddingValues(18.dp),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)

                ) {
                    Text(text = stringResource(SharedRes.strings.check_out_the_order))
                }
            }
        }
    }
}
