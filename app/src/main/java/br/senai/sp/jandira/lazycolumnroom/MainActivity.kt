package br.senai.sp.jandira.lazycolumnroom

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lazycolumnroom.components.ProductCard
import br.senai.sp.jandira.lazycolumnroom.dao.repository.ProductRepository
import br.senai.sp.jandira.lazycolumnroom.model.Product
import br.senai.sp.jandira.lazycolumnroom.ui.theme.LazyColumnRoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnRoomTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    var nameState by remember {
        mutableStateOf("")
    }

    var priceState by remember {
        mutableStateOf("")
    }

    var productsState by remember {
        mutableStateOf(listOf<Product>())
    }

    val context = LocalContext.current
    val productRepository = ProductRepository(LocalContext.current)
    productsState = productRepository.getProductList()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "PRODUCTS",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = nameState,
            onValueChange = {
                nameState = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 46.dp, end = 46.dp, top = 20.dp),
            label = {
                Text(text = "Nome")
            }
        )
        OutlinedTextField(
            value = priceState,
            onValueChange = {
                priceState = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 46.dp, end = 46.dp, top = 10.dp),
            label = {
                Text(text = "Preço")
            }
        )
        Button(
            onClick = {
                val p = Product(
                    productName = nameState,
                    productPrice = priceState.toDouble()
                )
                val newId = productRepository.save(p)
                productsState = productRepository.getProductList()
                Toast.makeText(context, "$newId", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 46.dp, end = 46.dp, top = 10.dp)
        ) {
            Text(text = "Salvar")
        }

        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {

//            items tem uma funcao parecida com o for mas com o mesmo efeito do recycler view
            items(productsState) {product ->
                ProductCard(product = product)
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    LazyColumnRoomTheme {
        Greeting("")
    }
}