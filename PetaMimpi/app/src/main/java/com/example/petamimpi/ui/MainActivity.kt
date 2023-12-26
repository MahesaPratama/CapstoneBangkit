
package com.example.petamimpi.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.petamimpi.R
import com.example.petamimpi.ui.auten.LoginActivity
import com.example.petamimpi.ui.theme.BlueBackground
import com.example.petamimpi.ui.theme.PetaMimpiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetaMimpiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Content()
                }
            }
        }
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}

@Composable
fun Content () {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().background(color = BlueBackground)
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Logo Aplikasi")
        Row {
            Text(text = "Peta", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 50.sp)
            Text(text = "mimpi", color = Color.White, fontSize = 50.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    PetaMimpiTheme {
        Content()
    }
}