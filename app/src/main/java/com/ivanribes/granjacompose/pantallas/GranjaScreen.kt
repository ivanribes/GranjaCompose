package com.ivanribes.granjacompose.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ivanribes.granjacompose.componentes.CabeceraGranja
import com.ivanribes.granjacompose.componentes.FormularioAnimal
import com.ivanribes.granjacompose.componentes.ListaAnimales
import com.ivanribes.granjacompose.modelo.Animal
import com.ivanribes.granjacompose.ui.theme.GranjaComposeTheme
import com.ivanribes.granjacompose.validacion.validarEdad
import com.ivanribes.granjacompose.validacion.validarEspecie
import com.ivanribes.granjacompose.validacion.validarNombre

@Composable
fun GranjaScreen(modifier: Modifier = Modifier) {
    var nombre by rememberSaveable { mutableStateOf("") }
    var especie by rememberSaveable { mutableStateOf("") }
    var edad by rememberSaveable { mutableStateOf("") }
    var error by rememberSaveable { mutableStateOf("") }
    var siguienteId by rememberSaveable { mutableIntStateOf(1) }

    val animales = rememberSaveable (
        saver = listSaver<SnapshotStateList<Animal>, Any>(
            save = {lista -> lista.flatMap { listOf(it.id, it.nombre, it.especie, it.edadMeses)}},
            restore = {datos -> datos.chunked(4).map { Animal(it[0] as Int, it[1] as String, it[2] as String, it[3] as Int) }
                .toMutableStateList() }
        )
    ) { mutableStateListOf<Animal>()}

    Column(modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)) {
        CabeceraGranja(total = animales.size, capacidad = 8)
        FormularioAnimal(
            nombre = nombre,
            especie = especie,
            edad = edad,
            error = error,
            registrarHabilitado = animales.size < 8,
            onNombreCambia = {nombre = it},
            onEspecieCambia = {especie = it},
            onEdadCambia = {edad = it},
            onRegistrar = {
                val mensaje = validarNombre(nombre) ?: validarEspecie(especie) ?: validarEdad(edad)
                if (mensaje != null) {
                    error = mensaje
                } else if (animales.size < 8) {
                    animales.add(Animal(siguienteId, nombre.trim(), especie.trim(), edad.trim().toInt()))
                    siguienteId++
                    nombre = ""
                    especie = ""
                    edad = ""
                    error = ""
                }
            }
            )
        ListaAnimales(
            animales = animales,
            onEliminar = { id -> animales.removeAll { it.id == id } },
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GranjaScreenPreview() {
    GranjaComposeTheme {
        GranjaScreen()
    }
}

@Preview(showBackground = true, widthDp = 780, heightDp = 360)
@Composable
fun GranjaScreenHorizontalPreview() {
    GranjaComposeTheme {
        GranjaScreen()
    }
}
