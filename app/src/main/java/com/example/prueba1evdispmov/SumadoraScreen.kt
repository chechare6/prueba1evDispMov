    package com.example.prueba1evdispmov

    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.Scaffold
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.collectAsState
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.navigation.*
    import com.example.prueba1evdispmov.ui.OperadorScreen
    import com.example.prueba1evdispmov.ui.StartScreen
    import com.example.prueba1evdispmov.ui.SumadoraViewModel

    enum class SumadoraScreen(){
    Start,
    Operaciones
}

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SumadoraApp() {
        val navController = rememberNavController()
        val backStackEntry by navController.currentBackStackEntryAsState()
        val viewModel: SumadoraViewModel = viewModel()

        Scaffold()
        { innerPadding ->
            val uiState by viewModel.uiState.collectAsState(),
            NavHost(
                navController = navController,
                startDestination = SumadoraScreen.Start.name
            ) {
                composable(route = SumadoraScreen.Start.name){
                    StartScreen(onSumButtonClicked = {
                        navController.navigate(SumadoraScreen.Operaciones.name)
                    })
                }

                composable(route = SumadoraScreen.Operaciones.name){
                    OperadorScreen(onBackButtonClicked = {
                        navController.navigate(SumadoraScreen.Start.name)
                    })
                }

            }


        }
    }

    @Preview
    @Composable
    fun SumadoraPreview(){
        SumadoraApp()
    }
