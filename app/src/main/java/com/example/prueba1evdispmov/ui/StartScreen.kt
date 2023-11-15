package com.example.prueba1evdispmov.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.prueba1evdispmov.R

@Composable
fun StartScreen(
    onSumButtonClicked: (Int, Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var sum1 by remember { mutableStateOf("") }
    var sum2 by remember { mutableStateOf("") }
    Column {
        Text(
            text = stringResource(R.string.sumador),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField(
            value = sum1,
            onValueChanged = { sum1 = it },
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
            value = sum2,
            onValueChanged = { sum2 = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        SumaButton {
            onSumButtonClicked(sum1.toInt(), sum2.toInt())
            println("${sum1.toInt() + sum2.toInt()}")
        }
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
    onClick: () -> Unit
) {
    Button(
        onClick = {
            onClick()
        },
    ) {
        Text(stringResource(R.string.sumar))
    }
}


@Preview
@Composable
fun StartSumPreview(){
    StartScreen(
        onSumButtonClicked = { sum1, sum2 ->  },
        modifier = Modifier
            .fillMaxSize()
    )
}
