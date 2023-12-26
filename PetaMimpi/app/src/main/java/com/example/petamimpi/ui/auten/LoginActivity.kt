package com.example.petamimpi.ui.auten

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petamimpi.R
import com.example.petamimpi.ui.navigation.BottomTabActivity
import com.example.petamimpi.ui.theme.BlueBackground
import com.example.petamimpi.ui.theme.PetaMimpiTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetaMimpiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login()
                }
            }
        }
    }
}

@Composable
fun Login() {
    val context = LocalContext.current
    val buttonModifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
    var emailValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var showSheet by remember { mutableStateOf(false) }
    if (showSheet) {
        BottomSheet {
            showSheet = false
        }
    }

    Column(
        modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = "LOGIN IMG",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 50.dp, horizontal = 35.dp)
        )
        Spacer(modifier = Modifier.weight(0.5f))
        Text(
            text = "Email",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = BlueBackground,
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = emailValue,
            onValueChange = { newText -> emailValue = newText },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = BlueBackground,
                unfocusedBorderColor = BlueBackground,
            )
        )
        if (emailValue.isNotEmpty()) {
            if (!isValidEmail(emailValue)) {
                Text(text = "Email is not valid", color = Color.Red, modifier = Modifier.align(Alignment.End).padding(top = 5.dp))
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Password",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = BlueBackground,
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = passwordValue,
            onValueChange = { newText -> passwordValue = newText },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = BlueBackground,
                unfocusedBorderColor = BlueBackground,
            ),
            trailingIcon = {
                IconButton(onClick = { showPassword = !showPassword }) {
                    Icon(
                        painter = painterResource(id = R.drawable.eye),
                        contentDescription = if (showPassword) "Show Password" else "Hide Password"
                    )
                }
            },
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(40.dp))
        ElevatedButton(
            onClick = {
                val intent = Intent(context, BottomTabActivity::class.java)
                context.startActivity(intent)
            },
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = BlueBackground,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(size = 20.dp),
            modifier = buttonModifier
        ) {
            Text(text = "Login", fontSize = 15.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        TextButton(
            onClick = { showSheet = true },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
            colors = ButtonDefaults.textButtonColors(contentColor = Color.Black)
        ) {
            Text(text = "Login with Google", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = Modifier.width(7.dp))
            Icon(painter = painterResource(id = R.drawable.google), contentDescription = "Google Login")
        }
        Spacer(modifier = Modifier.weight(1f))
        TextButton(
            onClick = {
                val intent = Intent(context, RegisterActivity::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        ) {
            Text(text = "Doesn't have an account?", color = Color.DarkGray, fontSize = 18.sp)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "Register", color = BlueBackground, fontSize = 18.sp)
        }
    }
}

fun isValidEmail(email: String): Boolean {
    val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
    return email.matches(emailRegex)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(onDismiss: () -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        AccountList()
    }
}

@Composable
fun AccountList() {
    val accounts = listOf(
        Pair("John Doe", "Johndoe@gmail.com"),
        Pair("Jane Doe", "Janedoe@gmail.com"),
        Pair("Bob Smith", "bobsmith@gmail.com"),
    )

    Column {
        Text(
            text = "Choose your account",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .padding(vertical = 15.dp)
        )

        LazyColumn {
            items(accounts) { (name, email) ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                        .background(Color.White),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(imageVector = Icons.Filled.Person, contentDescription = "Person logo")
                        Column {
                            Text(text = name)
                            Text(text = email)
                        }
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Person logo"
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        TextButton(
            onClick = { /* TODO */ },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        ) {
            Text(text = "Use another account?", color = Color.DarkGray, fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    PetaMimpiTheme {
        Login()
    }
}
