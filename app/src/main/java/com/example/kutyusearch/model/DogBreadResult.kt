package com.example.kutyusearch.model

data class DogBreadResult(
    val alt_names: String?,
    val experimental: Number?,
    val hairless: Number?,
    val hypoallergenic: Number?,
    val id: String?,
    val life_span: String?,
    val name: String?,
    val origin: String?,
    val natural: Number?,
    val rare: Number?,
    val reference_image_id: String?,
    val rex: Number?,
    val short_legs: Number?,
    val suppressed_tail: Number?,
    val temperament: String?,
    val wikipedia_url: String?,
    val image: ImageResult?
)