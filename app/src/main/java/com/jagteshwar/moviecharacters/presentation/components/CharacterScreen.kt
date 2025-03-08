package com.jagteshwar.moviecharacters.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jagteshwar.moviecharacters.presentation.state.CharacterState

@Composable
fun CharacterScreen(modifier: Modifier = Modifier,
                    characterState: CharacterState ) {

    if(characterState.isLoading){
        Box(modifier = modifier.fillMaxSize()){
            CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
        }
    }else if(!characterState.errorMsg.isNullOrEmpty()){
        Box(modifier = modifier.fillMaxSize()){
            Text(text = characterState.errorMsg.toString(), modifier = modifier.align(Alignment.Center))
        }
    }

    if(characterState.characterList?.isNotEmpty()!!){
        LazyColumn(modifier = modifier.background(Color.Black)) {
            items(characterState.characterList){
                CharacterItem(modifier = modifier, character = it)
            }
        }
    }

}