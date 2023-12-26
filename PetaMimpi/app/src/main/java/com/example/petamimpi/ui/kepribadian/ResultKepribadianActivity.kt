package com.example.petamimpi.ui.kepribadian

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

class ResultKepribadianActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetaMimpiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color(0xff4C4C4C)
                ) {
                    Greeting12()
                }
            }
        }
    }
}

@Composable
fun Greeting12() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .background(Color(0xff4C4C4C))
            .fillMaxSize()
            .padding(vertical = 30.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .background(Color.Gray, shape = RoundedCornerShape(size = 20.dp))
                .clip(RoundedCornerShape(size = 20.dp))
                .padding(10.dp)
        ) {
            Text(
                text = "Hasil",
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "The Guardian",
            textAlign = TextAlign.Center,
            fontSize = 35.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(size = 30.dp))
                .clip(RoundedCornerShape(size = 30.dp))
                .padding(15.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.intj), contentDescription = null)
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Tipe kepribadian kamu adalah", color = Color.White, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(50.dp))
        Box(
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(size = 20.dp))
                .clip(RoundedCornerShape(size = 20.dp))
                .padding(10.dp)
        ) {
            Text(
                text = "INTJ",
                textAlign = TextAlign.Center,
                fontSize = 45.sp,
                color = Color(0xff4C4C4C),
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(modifier = Modifier.clickable {
            val intent = Intent(context, DetailResultKepribadianActivity::class.java)
            context.startActivity(intent)
        }) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowUp,
                    contentDescription = null,
                    tint = Color.LightGray
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Geser untuk infomarsi lebih lanjut", color = Color.White)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview11() {
    PetaMimpiTheme {
        Greeting12()
    }
}