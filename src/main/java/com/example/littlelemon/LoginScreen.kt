package com.example.littlelemon

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    var username by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var password by remember {
        mutableStateOf(TextFieldValue(""))
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
            .padding(top = 90.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.yummyyardlogo
            ),
            contentDescription = "Logo Image",
            modifier = Modifier
                .padding(10.dp)
                .size(250.dp)
        )
        TextField(
            value = username,
            onValueChange = { username = it },
            modifier = Modifier
                .padding(10.dp),
            label = { Text(text = "Username") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            shape = RoundedCornerShape(30.dp)

        )
        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .padding(10.dp),
            label = { Text(text = "Password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(30.dp)

        )
        Button(
            onClick = {
                if (username.text == "umar"
                    && password.text == "umar"
                ) {
                    navController.navigate(Home.route)
                } else {
                    Toast.makeText(
                        context,
                        "Invalid credentials."
                                + "Please try again.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            },
            colors = ButtonDefaults.buttonColors(
                Color(0xFF495E57),
            ), shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .padding(10.dp)
                .size(width = 100.dp, height = 50.dp)
        ) {
            Text(
                text = "Login",
                color = Color(0xFFEDEFEE)
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        Row() {
            Text(text = "Don't have an account?", fontSize = 17.sp)
            Text(
                text = "sign-up",
                modifier = Modifier
                    .padding(start = 5.dp)
                    .clickable {
                        Toast
                            .makeText(
                                context,
                                "Source Unavailable",
                                Toast.LENGTH_LONG
                            )
                            .show()
                    },
                color = Color.Blue,
                fontSize = 17.sp
            )
        }
    }
}