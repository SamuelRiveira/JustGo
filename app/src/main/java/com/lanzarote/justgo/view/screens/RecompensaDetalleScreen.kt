package com.lanzarote.justgo.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lanzarote.justgo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecompensaDetalleScreen(
    recompensaId: String,
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalles de la Recompensa") },
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
            // Mapa/Imagen del local
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.restaurante_el_volcan),
                    contentDescription = "Ubicación del restaurante",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            // Información detallada
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Restaurante El Volcán",
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Detalles básicos
                ListItem(
                    headlineContent = { Text("15% de descuento") },
                    leadingContent = { Icon(Icons.Filled.ShoppingCart, null) }
                )
                ListItem(
                    headlineContent = { Text("Válido todos los días") },
                    leadingContent = { Icon(Icons.Filled.DateRange, null) }
                )
                ListItem(
                    headlineContent = { Text("Requiere 3 rutas completadas") },
                    leadingContent = { Icon(Icons.Filled.CheckCircle, null) }
                )

                // Información del local
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Sobre el Restaurante",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "Restaurante especializado en cocina tradicional canaria con vistas al volcán. Ambiente acogedor y terraza exterior."
                        )
                    }
                }

                // Horario
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Horario",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Lunes a Viernes: 12:00 - 23:00")
                        Text("Sábados y Domingos: 13:00 - 00:00")
                    }
                }

                // Condiciones de la recompensa
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Condiciones de la Recompensa",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("• Descuento aplicable sobre el total de la cuenta")
                        Text("• No acumulable con otras ofertas")
                        Text("• Válido para un máximo de 4 personas")
                        Text("• Necesario mostrar la app al pedir la cuenta")
                        Text("• Requiere haber completado 3 rutas")
                    }
                }
            }
        }
    }
}