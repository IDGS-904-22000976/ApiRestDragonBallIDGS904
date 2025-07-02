package com.example.apirestdragonballidgs904

import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class CharacterViewModel : ViewModel() {
    var characters by mutableStateOf<List<Character>>(emptyList())
        private set

    var selectedCharacter by mutableStateOf<Character?>(null)

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            try {
                characters = RetrofitInstance.api.getCharacters().items
            } catch (e: Exception) {
                Log.e("API", "Error al obtener personajes: ${e.message}")
            }
        }
    }
}
