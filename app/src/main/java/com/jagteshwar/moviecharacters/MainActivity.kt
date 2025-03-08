package com.jagteshwar.moviecharacters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jagteshwar.moviecharacters.presentation.navigation.Navigation
import com.jagteshwar.moviecharacters.presentation.theme.MovieCharactersTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieCharactersTheme {
                Navigation()
            }
        }
    }
}