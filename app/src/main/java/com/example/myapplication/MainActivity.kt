package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var amount by rememberSaveable(){mutableStateOf(0)}
            val contex = LocalContext.current
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center) {
                            Text("$amount")
                            Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center){
                                Button(onClick = {amount ++}) {
                                    Text(text = "+1")
                                }
                                Button(onClick = {amount --}) {
                                    Text(text = "-1")
                                }
                                Button(onClick = {amount *= 2}) {
                                    Text(text = "*2")
                                }
                                Button(onClick = {
                                    if(amount % 3 == 0){
                                        amount /= 3
                                    }
                                    else{
                                        Toast.makeText(contex, "не делится((", Toast.LENGTH_LONG).show()//тут я еще не очень поняла прикол с тем,
                                    // что он выдавал ошибку о не @Composable функции если вместо context вставлять его значение
                                    }
                                }) {
                                    Text(text = "/3")
                                }
                        }
                    }
                }
            }
        }
    }
}
/*
@Composable
fun ClickCounter(clicks: Int, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("I've been clicked $clicks times")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Greeting("Android")
        }
    }
}
*/