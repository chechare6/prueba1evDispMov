package com.example.prueba1evdispmov.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.prueba1evdispmov.R

@Composable
fun StartScreen(
    onSumButtonClicked: () -> Unit,
) {
    var sum1 = 0
    var sum2 = 0
    Column {
        Text(
            text = stringResource(R.string.sumador),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField(
            value = sum1.toString(),
            onValueChanged = { sum1 = it.toInt() },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        Text(
            text = stringResource(R.string.sumador),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField(
            value = sum2.toString(),
            onValueChanged = { sum2 = it.toInt() },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        SumaButton(
            onClick = { onSumButtonClicked() }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNumberField(
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier
) {
    TextField(
        value = value,
        singleLine = true,
        modifier = modifier,
        onValueChange = onValueChanged,
        label = { Text(stringResource(R.string.sum)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun SumaButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.widthIn(min = 250.dp)
    ) {}
}
