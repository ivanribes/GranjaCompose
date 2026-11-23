package com.ivanribes.granjacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ivanribes.granjacompose.pantallas.GranjaScreen
import com.ivanribes.granjacompose.ui.theme.GranjaComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GranjaComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    innerPadding ->
                    GranjaScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainActivityPreview() {
    GranjaComposeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            GranjaScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}
