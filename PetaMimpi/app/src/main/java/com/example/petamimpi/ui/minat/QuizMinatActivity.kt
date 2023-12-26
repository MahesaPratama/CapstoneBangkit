package com.example.petamimpi.ui.minat

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petamimpi.ui.theme.Orange
import com.example.petamimpi.ui.theme.PetaMimpiTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

data class MinatOptionValue(val name: String)

class QuizMinatActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetaMimpiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Orange
                ) {
                    Greeting7()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting7() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Pahami Minat",
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            color = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Orange),
                modifier = Modifier.fillMaxWidth(),
            )
        }
    ) {
        Surface(
            modifier = Modifier.padding(top = it.calculateTopPadding())
        ) {
            QuizMinatList()
        }
    }
}

@Composable
fun QuizMinatList() {
    var quizList by remember { mutableStateOf<List<String>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var isError by remember { mutableStateOf(false) }
    val apiUrl = "https://petamimpi-api-408806.et.r.appspot.com/interest-questions"
    val selectedOptionsListByQuiz by remember { mutableStateOf(mutableMapOf<String, MinatOptionValue>()) }

    LaunchedEffect(true) {
        withContext(Dispatchers.IO) {
            try {
                val data = fetchData(apiUrl)
                quizList = parseJson(data)
                isLoading = false
            } catch (e: Exception) {
                isError = true
                isLoading = false
                // Handle the error message if needed
                e.printStackTrace()
            }
        }
    }

    if (isLoading) {
        // Show loading state
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(modifier = Modifier.size(50.dp))
        }
    } else if (isError) {
        // Show error state
        Text("Error loading data. Please try again.")
    } else {
        // Show content when data is loaded
        LazyColumn(
            modifier = Modifier
                .background(Orange)
                .fillMaxSize()
                .padding(25.dp)
        ) {
            items(quizList) { quiz ->
                Box(
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .fillMaxSize()
                        .padding(15.dp)
                ) {
                    Column {
                        Text(
                            text = quiz, fontWeight = FontWeight.Bold, fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        var selectedOption by remember { mutableStateOf<MinatOptionValue?>(null) }

                        for (option in listOf(
                            MinatOptionValue("Ya"),
                            MinatOptionValue("Tidak"),
                        )) {
                            QuizMinatOption(option = option,
                                isSelected = selectedOption == option,
                                onClick = {
                                    selectedOption = it
                                    selectedOptionsListByQuiz[quiz] = it
                                })
                            Spacer(modifier = Modifier.height(15.dp))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                SubmitButton(selectedOptionsListByQuiz)
            }
        }
    }
}

fun parseResponseJson(response: String): String {
    val jsonObject = JSONObject(response)
    return jsonObject.getString("result") // Adjust this based on your actual response structure
}

@Composable
fun SubmitButton(selectedOptionsListByQuiz: MutableMap<String, MinatOptionValue>) {
    val coroutineScope = rememberCoroutineScope()
    var responseData by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current

    ElevatedButton(
        onClick = {
            val intent = Intent(context, ResultMinatActivity::class.java)
            context.startActivity(intent)
//            // Extracting the values from selected options in the desired order
//            val valuesList = mutableListOf<String>()
//            for (quiz in selectedOptionsListByQuiz.keys) {
//                selectedOptionsListByQuiz[quiz]?.let { optionValue ->
//                    valuesList.add(optionValue.name)
//                }
//            }
//
//            // Creating a JSONObject with the "responses" key and an array of values
//            val postData = JSONObject().apply {
//                put("responses", JSONArray(valuesList))
//            }
//            val jsonString = postData.toString()
//
//            coroutineScope.launch {
//                try {
//                    val response = postData(
//                        "https://petamimpi-api-408806.et.r.appspot.com/calculate-interes",
//                        jsonString
//                    )
//                    // Handle the response if needed
//                    println(response)
//
//                    // Now you can parse the response if it's in JSON format
//                    val parsedData = parseResponseJson(response)
//                    responseData = parsedData
//                } catch (e: Exception) {
//                    // Handle the error if needed
//                    e.printStackTrace()
//                }
//            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(bottom = 20.dp),
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = Color(0xff3DFF73), contentColor = Color.White
        ),
    ) {
        Text(text = "Submit", fontSize = 25.sp, color = Color.White)
    }
    responseData?.let {
        Text(text = "Response Data: $it", fontSize = 16.sp, color = Color.White)
    }
}


@Composable
fun QuizMinatOption(
    option: MinatOptionValue,
    isSelected: Boolean,
    onClick: (MinatOptionValue) -> Unit
) {
    val backgroundColor = if (isSelected) Color(0xff00FF0A) else Color.LightGray

    Box(modifier = Modifier
        .background(
            color = backgroundColor, shape = RoundedCornerShape(10.dp)
        )
        .fillMaxSize()
        .padding(15.dp)
        .clickable { onClick(option) }) {
        Text(
            text = option.name,
            color = if (isSelected) Color.White else Color.Black,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}


private suspend fun fetchData(apiUrl: String): String {
    return withContext(Dispatchers.IO) {
        val url = URL(apiUrl)
        val urlConnection = url.openConnection() as HttpURLConnection
        try {
            val reader = BufferedReader(InputStreamReader(urlConnection.inputStream))
            val stringBuilder = StringBuilder()
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                stringBuilder.append(line).append('\n')
            }
            stringBuilder.toString()
        } finally {
            urlConnection.disconnect()
        }
    }
}

private fun parseJson(data: String): List<String> {
    val jsonObject = JSONObject(data)
    val questionsArray = jsonObject.getJSONArray("questions")
    val questionsList = mutableListOf<String>()

    for (i in 0 until questionsArray.length()) {
        questionsList.add(questionsArray.getString(i))
    }

    return questionsList
}

private suspend fun postData(apiUrl: String, postData: String): String {
    return withContext(Dispatchers.IO) {
        val url = URL(apiUrl)
        val urlConnection = url.openConnection() as HttpURLConnection
        urlConnection.requestMethod = "POST"
        urlConnection.doOutput = true

        try {
            val outputStream = urlConnection.outputStream
            outputStream.write(postData.toByteArray())
            outputStream.flush()

            // Check the response code to determine if the request was successful
            if (urlConnection.responseCode == HttpURLConnection.HTTP_OK) {
                val reader = BufferedReader(InputStreamReader(urlConnection.inputStream))
                val stringBuilder = StringBuilder()
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    stringBuilder.append(line).append('\n')
                }
                stringBuilder.toString()
            } else {
                val errorStream = urlConnection.errorStream
                val errorReader = BufferedReader(InputStreamReader(errorStream))
                val errorResponse = StringBuilder()
                var errorLine: String?
                while (errorReader.readLine().also { errorLine = it } != null) {
                    errorResponse.append(errorLine).append('\n')
                }
                errorReader.close()
                throw Exception("HTTP error code: ${urlConnection.responseCode}, Response: $errorResponse")
            }
        } finally {
            urlConnection.disconnect()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview7() {
    PetaMimpiTheme {
        Greeting7()
    }
}