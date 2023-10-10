package com.phoenixoid.loginscreenjetpackcompose.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phoenixoid.loginscreenjetpackcompose.Screens.Common.AppIconButton
import com.phoenixoid.loginscreenjetpackcompose.Screens.Common.SpacerWidth
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
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple80)
    ) {
        Column {
            PizzaHeader()
            Card(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.fillMaxWidth()) {
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
                    text = "Longlatta",
                    style = TextStyle(fontSize = 25.sp)
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
            text = title,
            style = TextStyle(
                fontSize = 14.sp,
                color = if (selected) Color.White else Purple80
            )
        )
    }
}