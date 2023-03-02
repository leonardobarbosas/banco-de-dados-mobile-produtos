package br.senai.sp.jandira.lazycolumnroom.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lazycolumnroom.model.Product

@Composable
fun ProductCard(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        backgroundColor = Color(146, 146, 146, 255)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${product.id} - ${product.productName}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = product.productDescription,
                fontSize = 15.sp

            )
            Text(
                text = "$${product.productPrice}",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color(2, 134, 4, 255)
            )
        }
    }
}