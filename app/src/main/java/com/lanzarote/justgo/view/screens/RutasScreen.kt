package com.lanzarote.justgo.view.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lanzarote.justgo.view.components.RutaCard

@Composable
fun RutasScreen(navController: NavController = rememberNavController()) {
    val rutas = listOf(
        Triple("Ruta del Volcán", "Dificultad: Media • 5.2 km", "Una espectacular ruta por los volcanes de Lanzarote"),
        Triple("Costa de Famara", "Dificultad: Fácil • 3.8 km", "Paseo costero con vistas al océano"),
        Triple("Montaña Roja", "Dificultad: Difícil • 7.5 km", "Ascenso a uno de los puntos más altos de la isla")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Rutas de Senderismo",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(rutas) { (titulo, info, descripcion) ->
                RutaCard(
                    titulo = titulo,
                    info = info,
                    descripcion = descripcion,
                    onRutaClick = {
                        navController.navigate("ruta_detalle/${titulo.replace(" ", "_")}")
                    }
                )
            }
        }
    }
}