package com.example.kutyusearch.ui.description

import android.graphics.drawable.Drawable
import com.example.kutyusearch.model.DogBreadResult

interface DescriptionScreen {
    fun showDescription(bread: DogBreadResult)
    fun setImage(image: Drawable)
    fun showError(errorMsg: String)
}