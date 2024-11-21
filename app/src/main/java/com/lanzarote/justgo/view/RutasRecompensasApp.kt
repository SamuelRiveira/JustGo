package com.lanzarote.justgo.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.lanzarote.justgo.view.screens.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RutasRecompensasApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

                NavigationBarItem(
                    icon = { Icon(Icons.Filled.LocationOn, "Rutas") },
                    label = { Text("Rutas") },
                    selected = currentRoute == "rutas",
                    onClick = {
                        if (currentRoute != "rutas") {
                            navController.navigate("rutas") {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.ShoppingCart, "Recompensas") },
                    label = { Text("Recompensas") },
                    selected = currentRoute == "recompensas",
                    onClick = {
                        if (currentRoute != "recompensas") {
                            navController.navigate("recompensas") {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Person, "Perfil") },
                    label = { Text("Perfil") },
                    selected = currentRoute == "perfil",
                    onClick = {
                        if (currentRoute != "perfil") {
                            navController.navigate("perfil") {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "rutas",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("rutas") { RutasScreen(navController = navController) }
            composable("recompensas") { RecompensasScreen(navController = navController) }
            composable("perfil") { PerfilScreen(navController = navController) }
            composable("ruta_detalle/{rutaId}") { backStackEntry ->
                RutaDetalleScreen(
                    rutaId = backStackEntry.arguments?.getString("rutaId") ?: "1",
                    onNavigateBack = { navController.popBackStack() }
                )
            }
            composable("recompensa_detalle/{recompensaId}") { backStackEntry ->
                RecompensaDetalleScreen(
                    recompensaId = backStackEntry.arguments?.getString("recompensaId") ?: "",
                    onNavigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}