package com.sandoval.logincomposetest

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
	Box(
		Modifier
			.fillMaxSize()
			.padding(8.dp)
	) {
		HeaderLogin(Modifier.align(Alignment.TopEnd))
		BodyLogin(Modifier.align(Alignment.Center))
	}
}

@Composable
fun HeaderLogin(modifier: Modifier) {
	//val activity = LocalContext.current as Activity
	Icon(
		imageVector = Icons.Default.Close,
		contentDescription = "Close app image",
		modifier
		//modifier = modifier.clickable { activity.finish() }
	)
}

@Composable
fun BodyLogin(modifier: Modifier) {
	var email by rememberSaveable { mutableStateOf("") }
	var password by rememberSaveable { mutableStateOf("") }
	var isLoginEnable by rememberSaveable { mutableStateOf(false) }
	Column(modifier = modifier) {
		LoginImage(Modifier.align(Alignment.CenterHorizontally))
		Spacer(modifier = Modifier.size(16.dp))
		EmailLogin(email) { email = it }
		Spacer(modifier = Modifier.size(8.dp))
		PasswordLogin(password) { password = it }
		Spacer(modifier = Modifier.size(8.dp))
		ForgotPassword(Modifier.align(Alignment.End))
		Spacer(modifier = Modifier.size(16.dp))
		LoginButton(isLoginEnable)
	}
}

@Composable
fun LoginImage(modifier: Modifier) {
	Image(
		painter = painterResource(id = R.drawable.insta),
		contentDescription = "Login logo",
		modifier = modifier
	)
}

@Composable
fun EmailLogin(email: String, onEmailChange: (String) -> Unit) {
	TextField(
		value = email,
		onValueChange = { onEmailChange(it) },
		modifier = Modifier
			.fillMaxWidth()
			.padding(4.dp)
	)
}

@Composable
fun PasswordLogin(password: String, onPasswordChange: (String) -> Unit) {
	TextField(
		value = password,
		onValueChange = { onPasswordChange(it) },
		modifier = Modifier
			.fillMaxWidth()
			.padding(4.dp)
	)
}

@Composable
fun ForgotPassword(modifier: Modifier) {
	Text(
		text = "Forgot Password",
		fontSize = 12.sp,
		fontWeight = FontWeight.Bold,
		color = Color(0xFF4EA8E9),
		modifier = modifier
	)
}

@Composable
fun LoginButton(loginEnable: Boolean) {
	Button(
		onClick = { },
		enabled = loginEnable,
		modifier = Modifier.fillMaxWidth()
	) {
		Text("Log In")
	}
}



