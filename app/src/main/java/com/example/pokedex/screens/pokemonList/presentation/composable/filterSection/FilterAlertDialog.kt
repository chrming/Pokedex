package com.example.pokedex.screens.pokemonList.presentation.composable.filterSection

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FilterAlertDialogTest(
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

@Composable
fun FilterAlertDialog(
    modifier: Modifier = Modifier,
    title: String,
    filtersNames: Array<String>,
    onDismiss: () -> Unit,
    onItemClick: (String) -> Unit,
    itemColors: @Composable() ((String) -> ButtonColors) = { ButtonDefaults.buttonColors() }
) {
    AlertDialog(
        modifier = modifier,
        title = { Text(text = title) },
        onDismissRequest = onDismiss,
        text = {
            LazyVerticalGrid(modifier = Modifier, columns = GridCells.Fixed(2)) {
                items(items = filtersNames) {
                    TextButton(
                        modifier = Modifier
                            .padding(2.dp)
                            .width(IntrinsicSize.Max)
                            .height(IntrinsicSize.Max),
                        onClick = { onItemClick(it) },
                        colors = itemColors.invoke(it),
                    ) {
                        Text(text = it, textAlign = TextAlign.Center)
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
