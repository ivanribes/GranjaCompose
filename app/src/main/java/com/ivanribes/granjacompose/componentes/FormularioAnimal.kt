package com.ivanribes.granjacompose.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ivanribes.granjacompose.ui.theme.GranjaComposeTheme

@Composable
fun FormularioAnimal(
    nombre: String,
    especie: String,
    edad: String,
    error: String,
    registrarHabilitado: Boolean,
    onNombreCambia: (String) -> Unit,
    onEspecieCambia: (String) -> Unit,
    onEdadCambia: (String) -> Unit,
    onRegistrar: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            value = nombre,
            onValueChange = onNombreCambia,
            label = { Text("Nombre") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = especie,
            onValueChange = onEspecieCambia,
            label = { Text("Especie") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = edad,
            onValueChange = onEdadCambia,
            label = { Text("Edad en meses") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        if (error.isNotEmpty()) {
            Text(error, color = MaterialTheme.colorScheme.error)
        }
        Button(
            onClick = onRegistrar,
            enabled = registrarHabilitado,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar animal")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormularioVacioPreview() {
    GranjaComposeTheme {
        Surface {
            FormularioAnimal("", "", "", "", true, {}, {}, {}, {})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormularioConErrorPreview() {
    GranjaComposeTheme {
        Surface {
            FormularioAnimal("Luna", "vaca", "abc", "La edad debe ser un número entero de meses", true, {}, {}, {}, {})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormularioLlenoPreview() {
    GranjaComposeTheme {
        Surface {
            FormularioAnimal("Luna", "vaca", "12", "", false, {}, {}, {}, {})
        }
    }
}
