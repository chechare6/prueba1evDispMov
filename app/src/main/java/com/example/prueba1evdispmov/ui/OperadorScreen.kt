package com.example.prueba1evdispmov.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.prueba1evdispmov.R

@Composable
fun OperadorScreen(
    sum1: Int,
    sum2: Int,
    onBackButtonClicked: () -> Unit,
    modifier: Modifier
) {

    val operacion = "$sum1 + $sum2 = ${sum1 + sum2}"
    
    Column {
        Text(
            text = operacion,
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(R.string.operaciones),
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

@Preview
@Composable
fun OperadorScreenPreview(){
    OperadorScreen(
        sum1 = 5,
        sum2 = 3,
        onBackButtonClicked = { /*TODO*/ },
        modifier = Modifier.fillMaxSize())
}
