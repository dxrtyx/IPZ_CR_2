package ua.edu.lntu.cw_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.edu.lntu.cw_2.ui.theme.IPZ_CW_2_Vyrymchuk_BohdanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_CW_2_Vyrymchuk_BohdanTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Project()
                }
            }
        }
    }
}

@Composable
fun Project() {
    var sign by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }

    if (!sign) {
        Column(
            modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_main),
                contentDescription = "Email icon",
                modifier = Modifier.align(Alignment.CenterHorizontally),

            )
            OutlinedTextField(
                value = email,
                label = { Text("Email") },
                onValueChange = { email = it }
            )
            OutlinedTextField(
                value = password,
                label = { Text("Password") },
                onValueChange = { password = it }

            )
            Spacer(modifier = Modifier.height(18.dp))
            Button(onClick = {
                if (
                    email.text.isNotEmpty() && password.text.isNotEmpty()) {
                    sign = true
                }
            }) {
                Text("Sign In")
            }
        }
    } else {
        Column(
            modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Sign In Success")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Email: ${email.text}")
            Spacer(modifier = Modifier.height(18.dp))
            Button(onClick = {
                sign = false
                email = TextFieldValue()
                password = TextFieldValue()
            }) {
                Text("Sign Out")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProjectPreview() {
    IPZ_CW_2_Vyrymchuk_BohdanTheme {
        Project()
    }
}
