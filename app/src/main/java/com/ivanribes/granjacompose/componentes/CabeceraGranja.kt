package com.ivanribes.granjacompose.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ivanribes.granjacompose.ui.theme.GranjaComposeTheme

@Composable
fun CabeceraGranja(total: Int, capacidad: Int, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("Granja de Ivan Ribes", style = MaterialTheme.typography.headlineMedium)
        Text("Animales registrados: $total / $capacidad")
        if (total >= capacidad) {
            Text("Recinto completo", color = MaterialTheme.colorScheme.error)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CabeceraVaciaPreview() {
    GranjaComposeTheme {
        Surface { CabeceraGranja(total = 0, capacidad = 8) }
    }
}

@Preview(showBackground = true)
@Composable
fun CabeceraLlenaPreview() {
    GranjaComposeTheme {
        Surface { CabeceraGranja(total = 8, capacidad = 8) }
    }
}
