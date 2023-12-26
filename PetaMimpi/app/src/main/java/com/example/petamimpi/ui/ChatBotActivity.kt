package com.example.petamimpi.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petamimpi.ui.theme.BlueBackground
import com.example.petamimpi.ui.theme.GreyBlue
import com.example.petamimpi.ui.theme.PetaMimpiTheme

class ChatBotActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetaMimpiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting2() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Chatbot",
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            color = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = BlueBackground),
                modifier = Modifier.fillMaxWidth(),
            )
        }
    ) {
        Surface(
            modifier = Modifier.padding(top = it.calculateTopPadding())
        ) {
            ChatBotBody()
        }
    }
}

@Composable
fun ChatBotBody() {
    var chatValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 30.dp),
    ) {
        Box(
            modifier = Modifier
                .background(color = GreyBlue, shape = RoundedCornerShape(size = 16.dp))
                .padding(15.dp)
        ) {
            Text(
                text = "Tipe kepribadian saya INTJ, minat saya Realistic, dan bakat saya Verbal. Apa rekomendasi karir untuk saya?",
                color = Color.White
            )
        }
        Text(text = "10.28", fontSize = 12.sp, modifier = Modifier.align(Alignment.End).padding(top = 5.dp))
        Spacer(modifier = Modifier.height(15.dp))
        Box(
            modifier = Modifier
                .background(color = Color.LightGray, shape = RoundedCornerShape(size = 16.dp))
                .padding(15.dp)
        ) {
            Text(text = "Dengan kepribadian INTJ, minat Realistic, dan bakat Verbal, rekomendasi karir yang cocok termasuk analisis data atau ilmuwan komputer untuk memanfaatkan pemikiran analitis dan keterampilan praktis. Pilihan lainnya adalah menjadi insinyur atau arsitek, memanfaatkan bakat verbal dalam komunikasi ide sambil terlibat dalam pemecahan masalah teknis. Sebagai konsultan bisnis atau strategis, Anda dapat menggabungkan strategi INTJ dengan minat Realistic untuk memberikan solusi kompleks dan strategi perusahaan secara efektif.")
        }
        Text(text = "10.28", fontSize = 12.sp, modifier = Modifier.padding(top = 5.dp))
        Spacer(modifier = Modifier.weight(1f))
        OutlinedTextField(
            value = chatValue,
            onValueChange = { newText -> chatValue = newText },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = BlueBackground,
                unfocusedBorderColor = BlueBackground,
            ),
            placeholder = {
                Text(text = "Ketik yang ingin ditanyakan...")
            }
        )
    }

}

