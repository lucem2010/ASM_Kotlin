package com.example.lucdtph31250_asm1

import android.content.Intent
import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lucdtph31250_asm1.ui.theme.Lucdtph31250_asm1Theme

@Composable
fun Home(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            val imageModifier = Modifier
                .size(35.dp)
                .background(Color.White)
                .padding(top = 10.dp)
            Image(
                painter = painterResource(id = R.drawable.search),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = imageModifier
            )

            Column() {
                Text(
                    text = AnnotatedString("Make home"),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )
                Text(
                    text = AnnotatedString("BEAUTIFUL"),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Normal
                )
            }

            Image(
                painter = painterResource(id = R.drawable.bi_cart2),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = imageModifier
            )
        }

        var categorys = listOf(
        Category("1", "ok", R.drawable.chair)   ,
        Category("2", "ok1", R.drawable.chair),
        Category("3", "ok", R.drawable.chair),
        Category("4", "ok", R.drawable.chair),
        Category("5", "ok", R.drawable.chair)
        )
        CategoryList(categorys = categorys)
        var products= listOf(
            Product(
                id = 1,
                name = "Product 1",
                image = R.drawable.groupa, // replace with actual drawable resource ID
                price = 29.99,
                quantity = 10,
                description = "This is the description for Product 1.",
                rating = 4.5f,
                favorite = true
            ),
            Product(
                id = 2,
                name = "Product 2",
                image = R.drawable.groupp, // replace with actual drawable resource ID
                price = 19.99,
                quantity = 20,
                description = "This is the description for Product 2.",
                rating = 4.0f,
                favorite = false
            ),
            Product(
                id = 3,
                name = "Product 3",
                image = R.drawable.groupa, // replace with actual drawable resource ID
                price = 29.99,
                quantity = 10,
                description = "This is the description for Product 1.",
                rating = 4.5f,
                favorite = true
            ),
            Product(
                id = 4,
                name = "Product 4",
                image = R.drawable.groupp, // replace with actual drawable resource ID
                price = 19.99,
                quantity = 20,
                description = "This is the description for Product 2.",
                rating = 4.0f,
                favorite = false
            ),
        )
        ProductList(products = products,navController)
    }

}


@Composable
fun CategoryItem(category: Category) {
    Column(
        modifier = Modifier
            .width(44.dp)
            .height(60.dp)
            .padding(1.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(Color.Gray, shape = RoundedCornerShape(4.dp))
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(4.dp)
                )
                .wrapContentSize(Alignment.Center)
        ) {
            val imageModifier = Modifier
                .size(25.dp)
                .background(Color.White, shape = RoundedCornerShape(4.dp))

            Image(
                painter = painterResource(id = category.Img),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = imageModifier
            )
        }

        Text(
            text = category.Name,
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            fontStyle = FontStyle.Normal,
            modifier = Modifier.fillMaxWidth() // Ensure text is centered
        )
    }
}

@Composable
fun CategoryList(categorys: List<Category>) {
    LazyRow {
        items(categorys) { category ->
            CategoryItem(category)
        }
    }
}


@Composable
fun ProductItem(product: Product,navController: NavController) {
    Column(
        modifier = Modifier
            .width(175.dp)
            .height(260.dp)
            .padding(top =10.dp)
            .clickable {
                navController.currentBackStackEntry?.arguments?.putParcelable("product", product)
                navController.navigate("Detail")
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(4.dp)
                )
                .wrapContentSize(Alignment.Center)
        ) {
            val imageModifier = Modifier
                .fillMaxSize()

            Image(
                painter = painterResource(id = product.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = imageModifier
            )

        }

        Text(
            text = product.name,

            fontSize = 13.sp,

            modifier = Modifier.fillMaxWidth() // Ensure text is centered
        )
        Text(
            text = product.price.toString(),

            fontSize = 17.sp,
            modifier = Modifier.fillMaxWidth() // Ensure text is centered
        )
    }
}
@Composable
fun ProductList(products: List<Product>,navController: NavController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(4.dp),
        contentPadding = PaddingValues(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(products) { product ->
            ProductItem(product = product,navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewHome() {
    Lucdtph31250_asm1Theme {
        val navController = rememberNavController()
        Home(navController)
    }
}