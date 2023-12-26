package com.example.petamimpi.ui.minat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petamimpi.R
import com.example.petamimpi.ui.theme.PetaMimpiTheme

class DetailResultMinatActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetaMimpiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xff00323F)
                ) {
                    Greeting15()
                }
            }
        }
    }
}

@Composable
fun Greeting15() {
    Column(
        modifier = Modifier
            .background(Color(0xff00323F))
            .fillMaxSize()
            .padding(vertical = 30.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Investigative",
            textAlign = TextAlign.Center,
            fontSize = 35.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(30.dp))
        Image(painter = painterResource(id = R.drawable.investigasi), contentDescription = null)
        Spacer(modifier = Modifier.height(35.dp))
        Box(
            modifier = Modifier
                .padding(15.dp)
        ) {
            Text(
                text = "Karakteristik, Minat pada aktivitas yang melibatkan pemecahan masalah kompleks, penelitian, dan analisis data. Orang dengan minat ini cenderung suka mengeksplorasi ide dan konsep baru.",
                textAlign = TextAlign.Justify,
                fontSize = 18.sp,
                color = Color.White,
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        LazyColumn(
            modifier = Modifier
                .background(Color.DarkGray, shape = RoundedCornerShape(size = 20.dp))
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            item {
                Text(
                    text = "Artistic",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bar),
                        contentDescription = null,
                        modifier = Modifier.width(280.dp),
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        text = "80%",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                Text(
                    text = "Conventional",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bar),
                        contentDescription = null,
                        modifier = Modifier.width(240.dp),
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        text = "60%",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                Text(
                    text = "Enterprising",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bar),
                        contentDescription = null,
                        modifier = Modifier.width(200.dp),
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        text = "45%",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview14() {
    PetaMimpiTheme {
        Greeting15()
    }
}