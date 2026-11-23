package com.ivanribes.granjacompose.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ivanribes.granjacompose.modelo.Animal
import com.ivanribes.granjacompose.ui.theme.GranjaComposeTheme

@Composable
fun TarjetaAnimal(animal: Animal, onEliminar: () -> Unit, modifier: Modifier = Modifier) {
    Card(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(animal.nombre, style = MaterialTheme.typography.titleMedium)
                Text(animal.especie)
                Text("${animal.edadMeses} meses")
            }
            Button(onClick = onEliminar) { Text("Eliminar") }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TarjetaAnimalPreview() {
    GranjaComposeTheme {
        Surface {
            TarjetaAnimal(Animal(1, "Luna", "vaca", 24), onEliminar = {})
        }
    }
}
