package com.sandoval.logincomposetest

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen() {
	Box(
		Modifier
			.fillMaxSize()
			.padding(8.dp)
	) {
		HeaderLogin(Modifier.align(Alignment.TopEnd))
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



