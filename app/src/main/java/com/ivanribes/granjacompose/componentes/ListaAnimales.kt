package com.ivanribes.granjacompose.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ivanribes.granjacompose.modelo.Animal
import com.ivanribes.granjacompose.ui.theme.GranjaComposeTheme

@Composable
fun ListaAnimales(
    animales: List<Animal>,
    onEliminar: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    if (animales.isEmpty()) {
        Text("No hay animales registrados", modifier = modifier)
    } else {
        LazyColumn(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(animales, key = { it.id }) { animal ->
                TarjetaAnimal(animal = animal, onEliminar = { onEliminar(animal.id) })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListaVaciaPreview() {
    GranjaComposeTheme {
        Surface { ListaAnimales(animales = emptyList(), onEliminar = {}) }
    }
}

@Preview(showBackground = true)
@Composable
fun ListaConAnimalesPreview() {
    GranjaComposeTheme {
        Surface {
            ListaAnimales(
                animales = listOf(
                    Animal(1, "Luna", "vaca", 24),
                    Animal(2, "Luna", "oveja", 6)
                ),
                onEliminar = {}
            )
        }
    }
}
