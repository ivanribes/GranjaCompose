package com.ivanribes.granjacompose.validacion

fun validarNombre(nombre: String): String? {
    return if (nombre.trim().isEmpty()) "El nombre no puede estar vacío" else null
}

fun validarEspecie(especie: String): String? {
    return if (especie.trim().isEmpty()) "La especie no puede estar vacía" else null
}

fun validarEdad(edad: String): String? {
    val meses = edad.trim().toIntOrNull()
    return when {
        meses == null -> "La edad debe ser un número entero de meses"
        meses !in 0..360 -> "La edad debe estar entre 0 y 360 meses"
        else -> null
    }
}
