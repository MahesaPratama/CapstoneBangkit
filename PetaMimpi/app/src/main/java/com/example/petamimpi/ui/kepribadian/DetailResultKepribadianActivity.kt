package com.example.petamimpi.ui.kepribadian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petamimpi.R
import com.example.petamimpi.ui.theme.PetaMimpiTheme

class DetailResultKepribadianActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetaMimpiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Greeting13()
                }
            }
        }
    }
}

@Composable
fun Greeting13() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(vertical = 30.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .background(Color.Gray, shape = RoundedCornerShape(size = 15.dp))
                .clip(RoundedCornerShape(size = 15.dp))
                .padding(10.dp)
        ) {
            Text(
                text = "Penjelasan",
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(size = 25.dp))
                .clip(RoundedCornerShape(size = 25.dp))
                .padding(15.dp)
                .shadow(10.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.intj), contentDescription = null)
        }
        Spacer(modifier = Modifier.height(40.dp))
        Box(
            modifier = Modifier
                .background(Color(0xff4C4C4C), shape = RoundedCornerShape(size = 20.dp))
                .clip(RoundedCornerShape(size = 20.dp))
                .padding(15.dp)
        ) {
            Text(
                text = "INTJ",
                textAlign = TextAlign.Center,
                fontSize = 45.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Box(
            modifier = Modifier
                .background(Color.LightGray, shape = RoundedCornerShape(size = 20.dp))
                .clip(RoundedCornerShape(size = 20.dp))
                .padding(15.dp)
        ) {
            Text(
                text = "INTJ adalah pemikir strategis yang analitis dan inovatif. Mereka cenderung fokus pada pencapaian tujuan jangka panjang dan memiliki kemampuan untuk merancang rencana strategis. Pemikir Strategis seringkali berpikir secara konseptual dan suka mengeksplorasi ide-ide baru.",
                textAlign = TextAlign.Justify,
                fontSize = 17.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview12() {
    PetaMimpiTheme {
        Greeting13()
    }
}