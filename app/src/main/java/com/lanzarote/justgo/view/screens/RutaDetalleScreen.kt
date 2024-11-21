package com.lanzarote.justgo.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lanzarote.justgo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RutaDetalleScreen(
    rutaId: String,
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalles de la Ruta") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Filled.ArrowBack, "Volver")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            // Mapa (Imagen de placeholder)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ruta_del_volcan),
                    contentDescription = "Mapa de la ruta",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            // Información detallada
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Ruta del Volcán",
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Detalles básicos
                ListItem(
                    headlineContent = { Text("Dificultad: Media") },
                    leadingContent = { Icon(Icons.Filled.Warning, null) }
                )
                ListItem(
                    headlineContent = { Text("Distancia: 5.2 km") },
                    leadingContent = { Icon(Icons.Filled.Face, null) }
                )
                ListItem(
                    headlineContent = { Text("Duración: 2.5 horas") },
                    leadingContent = { Icon(Icons.Filled.DateRange, null) }
                )

                // Descripción
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Descripción",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "Una espectacular ruta que te llevará a través de los impresionantes paisajes volcánicos de Lanzarote. Durante el recorrido podrás observar diferentes formaciones geológicas y disfrutar de vistas panorámicas de la isla."
                        )
                    }
                }

                // Puntos de interés
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Puntos de Interés",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("• Mirador del Volcán")
                        Text("• Cueva de los Verdes")
                        Text("• Valle de la Tranquilidad")
                        Text("• Formaciones de Lava")
                    }
                }

                // Recomendaciones de seguridad
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Recomendaciones de Seguridad",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("• Llevar calzado apropiado para senderismo")
                        Text("• Mínimo 1.5L de agua por persona")
                        Text("• Protector solar y gorra")
                        Text("• Ropa adecuada según el clima")
                        Text("• Bastones de senderismo recomendados")
                        Text("• Llevar teléfono móvil con batería")
                    }
                }
            }
        }
    }
}