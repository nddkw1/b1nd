package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Calc(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CalcButton(
    text: String,
    color: Color = Color.Gray,
    onClick: () -> Unit
) {
        Box(
            modifier = Modifier
                .size(size=90.dp)
                .background(color, shape=RoundedCornerShape(size=16.dp))
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, fontSize = 24.sp, color = Color.White)
        }
}

@Composable
fun Calc(modifier: Modifier = Modifier) {
    var display by remember { mutableStateOf(value="0") }
    var number1 by remember { mutableIntStateOf(value=0) }
    var op by remember { mutableStateOf(value="") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(all=20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(height=150.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Text(
                text = display,
                fontSize = 40.sp,
                modifier = Modifier.padding(all=10.dp)
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                CalcButton("1") {
                    display = if (display == "0") "1" else display + "1"
                }
                CalcButton("2") {
                    display = if (display == "0") "2" else display + "2"
                }
                CalcButton("3") {
                    display = if (display == "0") "3" else display + "3"
                }
                CalcButton("+", Color(0xFFFF9800)) {
                    number1 = display.toIntOrNull() ?: 0
                    op = "+"
                    display = "0"
                }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                CalcButton("4") {
                    display = if (display == "0") "4" else display + "4"
                }
                CalcButton("5") {
                    display = if (display == "0") "5" else display + "5"
                }
                CalcButton("6") {
                    display = if (display == "0") "6" else display + "6"
                }
                CalcButton("-", Color(0xFFFF9800)) {
                    number1 = display.toIntOrNull() ?: 0
                    op = "-"
                    display = "0"
                }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                CalcButton("7") {
                    display = if (display == "0") "7" else display + "7"
                }
                CalcButton("8") {
                    display = if (display == "0") "8" else display + "8"
                }
                CalcButton("9") {
                    display = if (display == "0") "9" else display + "9"
                }
                CalcButton("×", Color(0xFFFF9800)) {
                    number1 = display.toIntOrNull() ?: 0
                    op = "×"
                    display = "0"
                }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                CalcButton("C", Color.Red) {
                    display = "0"
                    number1 = 0
                    op = ""
                }
                CalcButton("0") {
                    display = if (display == "0") "0" else display + "0"
                }
                CalcButton("=", Color(0xFF4CAF50)) {
                    val number2 = display.toIntOrNull() ?: 0

                    val result = when (op) {
                        "+" -> number1 + number2
                        "-" -> number1 - number2
                        "×" -> number1 * number2
                        "÷" -> if (number2 != 0) number1 / number2 else 0
                        else -> number2
                    }

                    display = result.toString()

                    op = ""
                    number1 = 0
                }
                CalcButton("÷", Color(0xFFFF9800)) {
                    number1 = display.toIntOrNull() ?: 0
                    op = "÷"
                    display = "0"
                }
            }
        }
    }
}