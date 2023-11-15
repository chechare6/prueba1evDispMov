    package com.example.prueba1evdispmov

    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.Scaffold
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Modifier
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.rememberNavController
    import com.example.prueba1evdispmov.ui.OperadorScreen
    import com.example.prueba1evdispmov.ui.StartScreen

    enum class SumadoraScreen {
    Start,
        Operador
}

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SumadoraApp() {
        val navController = rememberNavController()
        Scaffold()
        { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = SumadoraScreen.Start.name
            ) {
                composable(route = SumadoraScreen.Start.name){
                    StartScreen(
                        onSumButtonClicked = { sum1, sum2 ->
                        navController.navigate(SumadoraScreen.Operador.name)
                    },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }

                composable(route = SumadoraScreen.Operador.name){
                    OperadorScreen(
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
