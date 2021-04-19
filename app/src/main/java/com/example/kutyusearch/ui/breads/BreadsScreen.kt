package com.example.kutyusearch.ui.breads

import com.example.kutyusearch.model.DogBread

interface BreadsScreen {
    fun showBreads(breadsList: List<DogBread>)
    fun showError(errorMsg: String)
}