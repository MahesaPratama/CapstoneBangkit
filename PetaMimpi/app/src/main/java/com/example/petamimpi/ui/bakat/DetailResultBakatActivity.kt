package com.example.petamimpi.ui.bakat

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

class DetailResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetaMimpiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color(0xff001F3F)
                ) {
                    Greeting11()
                }
            }
        }
    }
}

@Composable
fun Greeting11() {
    Column(
        modifier = Modifier
            .background(Color(0xff001F3F))
            .fillMaxSize()
            .padding(vertical = 30.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Verbal",
            textAlign = TextAlign.Center,
            fontSize = 35.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(30.dp))
        Image(painter = painterResource(id = R.drawable.verbal), contentDescription = null)
        Spacer(modifier = Modifier.height(35.dp))
        Box(
            modifier = Modifier
                .background(Color.Black, shape = RoundedCornerShape(size = 20.dp))
                .padding(15.dp)
        ) {
            Text(
                text = "Kemampuan untuk berkomunikasi dengan baik melalui kata-kata, baik secara lisan maupun tertulis. Orang dengan kecerdasan verbal yang tinggi cenderung unggul dalam bahasa, sastra, dan komunikasi interpersonal.",
                textAlign = TextAlign.Justify,
                fontSize = 18.sp,
                color = Color.White,
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        LazyColumn(
            modifier = Modifier
                .background(Color.Gray, shape = RoundedCornerShape(size = 20.dp))
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            item {
                Text(
                    text = "Mathematical",
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
                    text = "Musical",
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
                    text = "Kinesthetic",
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
fun GreetingPreview10() {
    PetaMimpiTheme {
        Greeting11()
    }
}