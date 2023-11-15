    package com.example.prueba1evdispmov

    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.Scaffold
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Modifier
    import androidx.lifecycle.viewmodel.compose.viewModel
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.rememberNavController
    import com.example.prueba1evdispmov.ui.OperadorScreen
    import com.example.prueba1evdispmov.ui.StartScreen
    import com.example.prueba1evdispmov.ui.SumadorViewModel

    enum class SumadoraScreen {
    Start,
        Operador
}

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SumadoraApp() {
        val navController = rememberNavController()
        val viewModel: SumadorViewModel = viewModel()
        Scaffold()
        { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = SumadoraScreen.Start.name
            ) {
                composable(route = SumadoraScreen.Start.name){
                    StartScreen(
                        onSumButtonClicked = { sum1, sum2 ->
                            navController.navigate("${SumadoraScreen.Operador.name}?sum1=$sum1&sum2=$sum2&resultado=${sum1 + sum2}")
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }

                composable(route = "${SumadoraScreen.Operador.name}?sum1={sum1}&sum2={sum2}") { backStackEntry ->
                    val sum1 = backStackEntry.arguments?.getString("sum1")?.toInt() ?: 0
                    val sum2 = backStackEntry.arguments?.getString("sum2")?.toInt() ?: 0
                    val resultado = "$sum1 + $sum2 = ${sum1 + sum2}"
                    val historial = viewModel.getOperaciones()
                    viewModel.addOperacion(resultado)
                    OperadorScreen(
                        sum1 = sum1,
                        sum2 = sum2,
                        resultado = resultado,
                        historial = historial,
                        onBackButtonClicked = {
                        navController.navigate(SumadoraScreen.Start.name)
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }

            }
        }
    }
