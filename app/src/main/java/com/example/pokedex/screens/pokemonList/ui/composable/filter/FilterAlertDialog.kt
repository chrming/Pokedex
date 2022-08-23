package com.example.pokedex.screens.pokemonList.ui.composable.filter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FilterAlertDialog(
    modifier: Modifier = Modifier,
    title: String,
    rows: Int = 5,
    columns: Int = 4,
    filtersNames: Array<String>,
    onDismiss: () -> Unit,
    onItemClick: (String) -> Unit
) {
    AlertDialog(
        modifier = modifier,
        title = { Text(text = title) },
        onDismissRequest = onDismiss,
        text = {
            Column() {
                for (row in 1..rows) {
                    Row() {
                        for (column in 1..columns) {
                            val index = columns * (row - 1) + column - 1
                            Chip(
                                onClick = { onItemClick(filtersNames[index]) },
                                colors = ChipDefaults.chipColors()
                            ) {
                                Text(text = filtersNames[index])
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {

        },
        dismissButton = {

        }
    )
}
