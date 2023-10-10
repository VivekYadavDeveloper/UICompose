package com.phoenixoid.loginscreenjetpackcompose.Screens.Common

import android.graphics.drawable.Icon
import android.icu.text.ListFormatter.Width
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AppIconButton(
    tint: Color = Color.Unspecified,
    @DrawableRes icon: Int, modifier: Modifier = Modifier,
    onTap: () -> Unit = {}
) {

    IconButton(onClick = { onTap }, modifier = modifier.size(28.dp)) {
        androidx.compose.material3.Icon(
            painter = painterResource(id = icon),
            contentDescription = "",
            tint = tint
        )
    }
}

@Composable
fun SpacerWidth(width: Dp = 5.dp) {
    Spacer(modifier = Modifier.width(width))
}

@Composable
fun SpacerHeight(height: Dp = 5.dp) {
    Spacer(modifier = Modifier.width(height))
}