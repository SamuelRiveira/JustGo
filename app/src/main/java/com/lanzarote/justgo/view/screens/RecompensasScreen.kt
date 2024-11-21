package com.lanzarote.justgo.view.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lanzarote.justgo.view.components.RecompensaCard

@Composable
fun RecompensasScreen(navController: NavController) {
    val recompensas = listOf(
        Triple("Restaurante El Volcán", "15% de descuento", "Válido después de completar 3 rutas"),
        Triple("Café La Playa", "Bebida gratis", "Con la compra de cualquier plato principal"),
        Triple("Bar El Mirador", "2x1 en tapas", "Disponible los fines de semana")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Recompensas Disponibles",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(recompensas) { (nombre, descuento, condicion) ->
                RecompensaCard(
                    nombre = nombre,
                    descuento = descuento,
                    condicion = condicion,
                    onRecompensaClick = {
                        navController.navigate("recompensa_detalle/${nombre.replace(" ", "_")}")
                    }
                )
            }
        }
    }
}
