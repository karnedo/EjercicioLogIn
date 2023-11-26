package com.example.login.LoginScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.login.R

@Composable
fun LoginScreen(){
    Row(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        ){
            Image(painter = painterResource(id = R.drawable.background),
                contentDescription = "background",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize())
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1.7f)
        ) {
            Column (modifier = Modifier.fillMaxHeight().weight(1f)){
                Header(Modifier.padding(start = 20.dp))
                Body(Modifier.padding(start = 20.dp))
            }
            Footer(Modifier.fillMaxWidth())
        }
    }
}