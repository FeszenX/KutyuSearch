package com.example.kutyusearch.events

import android.graphics.drawable.Drawable
import com.example.kutyusearch.model.DogBread

class RxBusEvent {
    data class BreadsEvent(val breadsList: List<DogBread>)
    data class ImageEvent(val image: Drawable)
}