package com.example.travelplanner.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.travelplanner.Trip
import java.util.*

@Composable
fun AddTripScreen(navController: NavHostController) {
    var destination = ""
    var startDate = Date()
    var endDate = Date()
    var description = ""
    var price = 0.0

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Agregar un Nuevo Viaje", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        // Campo para el destino
        TextField(
            value = destination,
            onValueChange = { destination = it },
            label = { Text("Destino") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Campo para la descripción
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Descripción") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Campo para el presupuesto
        TextField(
            value = price.toString(),
            onValueChange = { price = it.toDoubleOrNull() ?: 0.0 },
            label = { Text("Presupuesto") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para guardar el viaje
        Button(
            onClick = {
                val trip = Trip(
                    id = 0, // Aquí podrías agregar lógica para generar un ID único
                    destination = destination,
                    startDate = startDate,
                    endDate = endDate,
                    description = description,
                    price = price
                )

                // Aquí podrías hacer algo con el objeto trip, por ejemplo, guardarlo en una base de datos
                Toast.makeText(navController.context, "Viaje agregado: ${trip.destination}", Toast.LENGTH_SHORT).show()

                // Después de agregar el viaje, puedes navegar a otra pantalla, por ejemplo, la pantalla de inicio
                navController.navigate("home")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Viaje")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddTripScreenPreview() {
    AddTripScreen(navController = rememberNavController())
}
