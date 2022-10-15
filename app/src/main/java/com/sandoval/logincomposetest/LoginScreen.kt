package com.sandoval.logincomposetest

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
		Footer(Modifier.align(Alignment.BottomCenter))
	}
}

@Composable
fun HeaderLogin(modifier: Modifier) {
	//val activity = LocalContext.current as Activity
	Icon(
		imageVector = Icons.Default.Close, contentDescription = "Close app image", modifier
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
		EmailLogin(email) {
			email = it
			isLoginEnable = enableLogin(email, password)
		}
		Spacer(modifier = Modifier.size(8.dp))
		PasswordLogin(password) {
			password = it
			isLoginEnable = enableLogin(email, password)
		}
		Spacer(modifier = Modifier.size(8.dp))
		ForgotPassword(Modifier.align(Alignment.End))
		Spacer(modifier = Modifier.size(16.dp))
		LoginButton(isLoginEnable)
		Spacer(modifier = Modifier.size(16.dp))
		LoginDivider()
		Spacer(modifier = Modifier.size(32.dp))
		SocialLogin()
	}
}

@Composable
fun Footer(modifier: Modifier) {
	Column(modifier = modifier.fillMaxWidth()) {
		Divider(
			Modifier
				.background(Color(0XFFF9F9F9))
				.height(1.dp)
				.fillMaxWidth()
		)
		Spacer(modifier = Modifier.size(24.dp))
		SignUp()
		Spacer(modifier = Modifier.size(24.dp))
	}
}

@Composable
fun SignUp() {
	Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
		Text(
			text = "Don't have an account?",
			fontSize = 12.sp,
			color = Color(0XFFB5B5B5),
			fontWeight = FontWeight.Medium
		)
		Text(
			text = "Sign up.",
			fontSize = 12.sp,
			modifier = Modifier.padding(horizontal = 8.dp),
			fontWeight = FontWeight.ExtraBold,
			color = Color(0xFF4EA8E9)
		)
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
			.padding(4.dp),
		placeholder = { Text(text = "Email") },
		maxLines = 1,
		singleLine = true,
		keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
		colors = TextFieldDefaults.textFieldColors(
			textColor = Color(0xFFB2B2B2),
			backgroundColor = Color(0xFFF5F5F5),
			focusedIndicatorColor = Color.Transparent,
			unfocusedIndicatorColor = Color.Transparent
		)
	)
}

@Composable
fun PasswordLogin(password: String, onPasswordChange: (String) -> Unit) {
	var passwordVisibility by rememberSaveable { mutableStateOf(false) }
	TextField(
		value = password,
		onValueChange = { onPasswordChange(it) },
		modifier = Modifier
			.fillMaxWidth()
			.padding(4.dp),
		placeholder = { Text(text = "Password") },
		maxLines = 1,
		singleLine = true,
		keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
		colors = TextFieldDefaults.textFieldColors(
			textColor = Color(0xFFB2B2B2),
			backgroundColor = Color(0xFFF5F5F5),
			focusedIndicatorColor = Color.Transparent,
			unfocusedIndicatorColor = Color.Transparent
		),
		trailingIcon = {
			val image = if (passwordVisibility) {
				Icons.Filled.VisibilityOff
			} else {
				Icons.Filled.Visibility
			}
			IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
				Icon(imageVector = image, contentDescription = "Show password image")
			}
		},
		visualTransformation = if (passwordVisibility) {
			VisualTransformation.None
		} else {
			PasswordVisualTransformation()
		}
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
		modifier = Modifier.fillMaxWidth(),
		colors = ButtonDefaults.buttonColors(
			backgroundColor = Color(0xFF00A3FC),
			disabledBackgroundColor = Color(0xFF88D0F7),
			contentColor = Color.White,
			disabledContentColor = Color.White
		)
	) {
		Text("Log In")
	}
}

@Composable
fun LoginDivider() {
	Row(
		modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
	) {
		Divider(
			Modifier
				.background(Color(0XFFF9F9F9))
				.height(1.dp)
				.weight(1f)
		)
		Text(
			text = "OR",
			modifier = Modifier.padding(horizontal = 16.dp),
			fontSize = 12.sp,
			fontWeight = FontWeight.Bold,
			color = Color(0XFFB5B5B5)
		)
		Divider(
			Modifier
				.background(Color(0XFFF9F9F9))
				.height(1.dp)
				.weight(1f)
		)

	}
}

@Composable
fun SocialLogin() {
	Row(
		modifier = Modifier.fillMaxWidth(),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.Center
	) {
		Image(
			painter = painterResource(id = R.drawable.fb),
			contentDescription = "Social login facebook image",
			Modifier.size(24.dp)
		)
		Text(
			text = "Continue as Juan Camilo",
			fontSize = 14.sp,
			fontWeight = FontWeight.Bold,
			modifier = Modifier.padding(horizontal = 8.dp),
			color = Color(0xFF4EA8E9)
		)
	}
}

fun enableLogin(email: String, password: String) =
	Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6




