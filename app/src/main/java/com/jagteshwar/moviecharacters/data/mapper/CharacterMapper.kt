package com.jagteshwar.moviecharacters.data.mapper

import com.jagteshwar.moviecharacters.data.dto.CharacterDto
import com.jagteshwar.moviecharacters.domain.model.Character

fun CharacterDto.toCharacter():Character = Character(
    actor = actor,
    id = id,
    image = image,
    name = name
)


