package com.example.petamimpi.ui.profile

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petamimpi.R
import com.example.petamimpi.ui.theme.BlueBackground

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "My Profile",
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            color = Color.White
                        )
                    }

                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = BlueBackground),
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) {
        BodyProfile()
    }
}

@Composable
fun BodyProfile() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.face),
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.width(25.dp))
            Column(
                modifier = Modifier
                    .padding(bottom = 40.dp)
            ) {
                Text(
                    text = "JohnDoe",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.padding(vertical = 2.dp))
                Box(
                    modifier = Modifier
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(size = 12.dp)
                        )
                        .padding(7.dp)
                ) {
                    Text(
                        text = "Bergabung 15 Desember 2023",
                        fontSize = 15.sp,
                        style = TextStyle(
                            background = Color.LightGray
                        )
                    )
                }

            }
        }
        OutlinedButton(
            onClick = {
                val intent = Intent(context, EditProfileAcitivity::class.java)
                context.startActivity(intent)
            },
            shape = RoundedCornerShape(size = 12.dp),
            border = BorderStroke(0.8.dp, Color.Black),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Edit Profil", fontWeight = FontWeight.Bold, color = Color.Black)
        }
        Spacer(modifier = Modifier.padding(vertical = 35.dp))
        Text(text = "Tentang Diriku", fontWeight = FontWeight.Bold, fontSize = 30.sp)
        Spacer(modifier = Modifier.padding(vertical = 15.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    BorderStroke(width = 0.5.dp, color = Color.Black),
                    shape = RoundedCornerShape(size = 15.dp)
                )
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Tipe Kepribadian",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .padding(7.dp)
                ) {
                    Text(
                        text = "Tidak diketahui",
                        color = Color(0xff336699),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(
                            background = Color.LightGray
                        )
                    )
                }
                Spacer(modifier = Modifier.height(17.dp))
                Text(
                    text = "Minat",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .padding(7.dp)
                ) {
                    Text(
                        text = "Tidak diketahui",
                        color = Color(0xff9900CC),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(
                            background = Color.LightGray
                        )
                    )
                }
                Spacer(modifier = Modifier.height(17.dp))
                Text(
                    text = "Bakat",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .padding(7.dp)
                ) {
                    Text(
                        text = "Tidak diketahui",
                        color = Color(0xffFF9900),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(
                            background = Color.LightGray
                        )
                    )
                }
            }

        }
    }
}
