package com.example.petamimpi.ui.kepribadian

import android.content.Intent
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petamimpi.R
import com.example.petamimpi.ui.theme.GreyBlue
import com.example.petamimpi.ui.theme.PetaMimpiTheme

class KepribadianActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetaMimpiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = GreyBlue
                ) {
                    Greeting4()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting4() {
    Scaffold(
        topBar = {
            LocalContext.current.applicationContext
            TopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Pahami Kepribadian",
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            color = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = GreyBlue),
                modifier = Modifier.fillMaxWidth(),
            )
        }
    ) {
        Surface(
            modifier = Modifier.padding(top = it.calculateTopPadding())
        ) {
            ContentKepribadian()
        }
    }
}

@Composable
fun ContentKepribadian() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .background(GreyBlue)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 25.dp, vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.kepribadian), contentDescription = null)
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .background(Color(0xffE1F0FF), shape = RoundedCornerShape(size = 16.dp))
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(20.dp)
            ) {
                Text(
                    text = "Test Kepribadian adalah alat evaluasi pskilogis untuk menggungkapkan ciri-ciri dan perilaku seseorang",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,

                    )
            }
            Spacer(modifier = Modifier.weight(1f))
            ElevatedButton(
                onClick = {
                    val intent = Intent(context, QuizKepribadianActivity::class.java)
                    context.startActivity(intent)
                },
                shape = RoundedCornerShape(size = 20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Mulai", color = GreyBlue, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    PetaMimpiTheme {
        Greeting4()
    }
}