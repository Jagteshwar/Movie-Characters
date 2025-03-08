package com.jagteshwar.moviecharacters.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jagteshwar.moviecharacters.presentation.components.CharacterScreen
import com.jagteshwar.moviecharacters.presentation.viewmodel.CharactersViewModel

@Composable
fun Navigation() {
    
    val navController = rememberNavController()

    val viewModel: CharactersViewModel = hiltViewModel()
    val characterState = viewModel.characterState.collectAsStateWithLifecycle()
    
    NavHost(navController = navController, startDestination = Routes.CharacterScreen.route) {
       composable(route = Routes.CharacterScreen.route){
           CharacterScreen(modifier = Modifier, characterState = characterState.value)
       }
    }
    
}