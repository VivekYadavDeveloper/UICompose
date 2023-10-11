package com.phoenixoid.loginscreenjetpackcompose.Screens

import android.graphics.Paint.Align
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phoenixoid.loginscreenjetpackcompose.R
import com.phoenixoid.loginscreenjetpackcompose.Screens.Common.AppIconButton
import com.phoenixoid.loginscreenjetpackcompose.Screens.Common.SpacerHeight
import com.phoenixoid.loginscreenjetpackcompose.Screens.Common.SpacerWidth
import com.phoenixoid.loginscreenjetpackcompose.data.Pizza
import com.phoenixoid.loginscreenjetpackcompose.data.pizzaList
import com.phoenixoid.loginscreenjetpackcompose.ui.theme.Purple40
import com.phoenixoid.loginscreenjetpackcompose.ui.theme.Purple80
import com.phoenixoid.loginscreenjetpackcompose.ui.theme.selectedPink


@Composable
fun HomeScreen() {

    val menuList = listOf(
        "Stater",
        "South Indian",
        "Longlatta",
        "RajBogh",
        "Imirti",
        "Longlatta Khoya",
    )
    var currentMenuState by remember { mutableStateOf("Stater") }

    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple80)
    ) {
        Column {
            PizzaHeader()
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(scrollState)
                ) {
                    menuList.forEach {
                        CustomChips(
                            title = it,
                            selected = it == currentMenuState,
                            onValueChange = { data ->
                                currentMenuState = data
                            })
                    }
                }
            }

            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(pizzaList) {
                    ShowPizza(pizza = it)
                }
            }
        }
        ExtendedFloatingActionButton(
            modifier = Modifier
                .padding(
                    horizontal = 20.dp, vertical = 30.dp
                )
                .align(alignment = Alignment.BottomEnd)
        )

    }
}


/*List Food List*/
@Composable
fun ShowPizza(
    pizza: Pizza
) {
    Card(
        modifier = Modifier
            .width(165.dp)
            .padding(5.dp), shape = RoundedCornerShape(5.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {

            Column(
                modifier = Modifier.padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(

                    painter = painterResource(id = R.drawable.one),
                    alignment = Alignment.Center,
                    contentDescription = "",

                    modifier = Modifier.size(108.dp)
                )
                SpacerHeight(5.dp)
                Text(
                    text = pizza.price, style = TextStyle(
                        fontSize = 14.sp, color = Color.Red, textAlign = TextAlign.Center
                    )
                )
                SpacerHeight(5.dp)
                Text(
                    text = pizza.name, style = TextStyle(
                        fontSize = 14.sp, color = Color.DarkGray, textAlign = TextAlign.Center
                    )
                )
                SpacerHeight(5.dp)
                Text(
                    text = pizza.description, style = TextStyle(
                        fontSize = 10.sp, color = Color.Black, textAlign = TextAlign.Center
                    )
                )
                SpacerHeight(5.dp)
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.width(91.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = ButtonDefaults.buttonColors(Purple40)


                ) {

                    Text(
                        text = "Add", style = TextStyle(fontSize = 10.sp, color = Color.White)
                    )
                }

            }
        }
    }

}


/*AppBar Section*/
@Composable
fun PizzaHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Purple40)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            /*Menu And Title Row Section*/
            Row {
                AppIconButton(icon = com.phoenixoid.loginscreenjetpackcompose.R.drawable.menu_24)
                SpacerWidth(10.dp)
                Text(
                    text = "Longlatta", style = TextStyle(fontSize = 25.sp)
                )
            }

            /*Search Section*/
            AppIconButton(icon = com.phoenixoid.loginscreenjetpackcompose.R.drawable.searched_24)
        }
    }
}


/*Chips Section*/
@Composable
fun CustomChips(title: String, selected: Boolean, onValueChange: (String) -> Unit) {
    TextButton(
        onClick = {
            onValueChange(title)
        },
        shape = RoundedCornerShape(200.dp),
        elevation = ButtonDefaults.buttonElevation(0.dp),
        colors = ButtonDefaults.buttonColors(contentColor = if (selected) selectedPink else Color.Transparent),
        modifier = Modifier.padding(10.dp)
    )

    {


        Text(
            text = title, style = TextStyle(
                fontSize = 14.sp, color = if (selected) Color.White else Purple80
            )
        )
    }
}


/*Extended Floating Action Button*/


@Composable
fun ExtendedFloatingActionButton(

    modifier: Modifier
) {
    Box(
        modifier = modifier
            .height(48.dp)
            .clip(RoundedCornerShape(27.dp))
            .background(Purple40)
    ) {
        SpacerWidth()

        Row(modifier = Modifier.align(alignment = Alignment.Center)) {
            Text(
                text = "$60.50",
                style = TextStyle(fontSize = 18.sp, color = Color.White),
                modifier = Modifier.align(CenterVertically)
            )
            Icon(
                painter = painterResource(id = R.drawable.four),
                contentDescription = "",
                modifier = Modifier
                    .size(46.dp)
                    .padding(2.dp),
                tint = Color.Unspecified
            )

        }
    }
}