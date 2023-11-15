package com.example.prueba1evdispmov.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.prueba1evdispmov.R

@Composable
fun OperadorScreen(
    sum1: Int,
    sum2: Int,
    resultado: String,
    historial: List<String>,
    onBackButtonClicked: () -> Unit,
    modifier: Modifier
) {
    Column {
        Text(
            text = resultado,
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = buildString {
                appendLine(stringResource(R.string.operaciones))
                historial.forEach { appendLine(it) }
            },
            style = MaterialTheme.typography.displaySmall
        )
        BackButton(
            onClick = { onBackButtonClicked() }
        )
    }
}

@Composable
fun BackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
    ) {
    Button(onClick = onClick,
        modifier = modifier.widthIn(min = 250.dp)
    ) {
        Text(stringResource(R.string.volver))
    }
}
