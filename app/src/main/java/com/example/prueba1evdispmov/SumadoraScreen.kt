    package com.example.prueba1evdispmov

    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.Scaffold
    import androidx.compose.runtime.Composable
    //import androidx.compose.runtime.getValue
    import androidx.compose.ui.Modifier
    //import androidx.lifecycle.viewmodel.compose.viewModel
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    //import androidx.navigation.compose.currentBackStackEntryAsState
    import androidx.navigation.compose.rememberNavController
    import com.example.prueba1evdispmov.ui.OperadorScreen
    import com.example.prueba1evdispmov.ui.StartScreen
    //import com.example.prueba1evdispmov.ui.SumadoraViewModel

    enum class SumadoraScreen {
    Start,
        Operador
}

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SumadoraApp() {
        val navController = rememberNavController()
        //val backStackEntry by navController.currentBackStackEntryAsState()
        //val viewModel: SumadoraViewModel = viewModel()

        Scaffold()
        { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = SumadoraScreen.Start.name
            ) {
                composable(route = SumadoraScreen.Start.name){
                    StartScreen(
                        onSumButtonClicked = {
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
