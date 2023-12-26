package com.example.petamimpi.ui

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ComponentActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.petamimpi.R
import com.example.petamimpi.ui.bakat.BakatActivity
import com.example.petamimpi.ui.kepribadian.KepribadianActivity
import com.example.petamimpi.ui.minat.MinatActivity
import com.example.petamimpi.ui.theme.BlueBackground

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = "LOGIN IMG",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(20.dp)),
            colors = CardDefaults.cardColors(
                containerColor = BlueBackground,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.face),
                    contentDescription = "image",
                    modifier = Modifier
                        .size(140.dp)
                        .clip(CircleShape)
                )
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                ) {
                    Text(
                        text = "Hai, JohnDoe",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                    Text(
                        text = "Selamat Pagi!",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Home",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier.padding(start = 20.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        GridList()

    }
}

@Composable
fun GridList() {
    val context = LocalContext.current

    data class Menu(
        val name: String,
        val imageResId: Int,
        val activityClass: Class<out ComponentActivity>
    )

    val menuList = listOf(
        Menu("Pahami Kepribadian", R.drawable.pahami, KepribadianActivity::class.java),
        Menu("Kenali Minat", R.drawable.kenali, MinatActivity::class.java),
        Menu("Temukan Bakat", R.drawable.temukan, BakatActivity::class.java),
        Menu("Tanyakan Sesuatu", R.drawable.tanyakan, ChatBotActivity::class.java),
    )
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        userScrollEnabled = false,
        columns = GridCells.Fixed(count = 2),
        verticalArrangement = Arrangement.spacedBy(space = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(space = 16.dp),
        contentPadding = PaddingValues(all = 10.dp)
    ) {
        items(menuList) { menu ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(size = 16.dp))
                    .clip(RoundedCornerShape(size = 16.dp))
                    .padding(10.dp)
                    .clickable {
                        val intent = Intent(context, menu.activityClass)
                        startActivity(context, intent, null)
                    },
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = menu.imageResId),
                        contentDescription = null, // set to null if no content description is needed
                        modifier = Modifier
                            .size(80.dp)
                            .clip(RoundedCornerShape(40.dp))
                    )
                    Text(
                        text = menu.name,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}