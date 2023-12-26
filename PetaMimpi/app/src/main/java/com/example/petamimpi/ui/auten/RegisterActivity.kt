package com.example.petamimpi.ui.auten

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petamimpi.R
import com.example.petamimpi.ui.navigation.BottomTabActivity
import com.example.petamimpi.ui.theme.BlueBackground
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            com.example.petamimpi.ui.theme.PetaMimpiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Register()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register() {
    val context = LocalContext.current
    val buttonModifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
    var emailValue by remember { mutableStateOf("") }
    var nameValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }

    val calendar = Calendar.getInstance()

    // set the initial date
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = calendar.timeInMillis,
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return utcTimeMillis <= System.currentTimeMillis()
            }

            // users cannot select the years from 2024
            override fun isSelectableYear(year: Int): Boolean {
                return year <= 2023
            }
        }
    )

    var showDatePicker by remember {
        mutableStateOf(false)
    }

    var selectedDate by remember {
        mutableLongStateOf(calendar.timeInMillis) // or use mutableStateOf(calendar.timeInMillis)
    }

    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = {
                showDatePicker = false
            },
            confirmButton = {
                TextButton(onClick = {
                    showDatePicker = false
                    selectedDate = datePickerState.selectedDateMillis!!
                }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showDatePicker = false
                }) {
                    Text(text = "Cancel")
                }
            }
        ) {
            DatePicker(
                state = datePickerState
            )
        }
    }

    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.ROOT)

    Column(
        modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = "LOGIN IMG",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 50.dp, horizontal = 35.dp)
        )
        Text(
            text = "Nama",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = BlueBackground,
        )
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        OutlinedTextField(
            value = nameValue,
            onValueChange = { newText -> nameValue = newText },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = BlueBackground,
                unfocusedBorderColor = BlueBackground,
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Email",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = BlueBackground,
        )
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
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
                Text(
                    text = "Email is not valid", color = Color.Red, modifier = Modifier
                        .align(Alignment.End)
                        .padding(top = 5.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Tanggal Lahir",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = BlueBackground,
        )

        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        OutlinedTextField(
            value = formatter.format(Date(selectedDate)),
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = BlueBackground,
                unfocusedBorderColor = BlueBackground,
            ),
            trailingIcon = {
                IconButton(onClick = {
                    showDatePicker = true
                }) {
                    Icon(
                        imageVector = Icons.Outlined.DateRange,
                        contentDescription = "Select Date"
                    )
                }
            },
            readOnly = true
        )

        Spacer(modifier = Modifier.height(20.dp))
        // Password TextField
        Text(
            text = "Password",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = BlueBackground,
        )
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
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
        Spacer(modifier = Modifier.height(30.dp))
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
            Text(text = "Daftar", fontSize = 15.sp)
        }
        Spacer(modifier = Modifier.weight(1f))
        TextButton(
            onClick = {
                val intent = Intent(context, LoginActivity::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        ) {
            Text(text = "Udah punya akun?", color = Color.DarkGray, fontSize = 18.sp)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "Masuk", color = BlueBackground, fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    com.example.petamimpi.ui.theme.PetaMimpiTheme {
        Register()
    }
}

