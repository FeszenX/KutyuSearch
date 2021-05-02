package com.example.kutyusearch.ui.description

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kutyusearch.R
import com.example.kutyusearch.model.DogBread
import com.example.kutyusearch.model.DogBreadResult
import kotlinx.android.synthetic.main.activity_dog_description.*
import java.io.InputStream
import java.net.URL


class DogDescription : AppCompatActivity(), DescriptionScreen {

    private lateinit var breadId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_description)
        setSupportActionBar(findViewById(R.id.toolbar))

        val intentBreadId = intent.getStringExtra("BREAD_ID")

        if (intentBreadId !== null) {
            this.breadId = intentBreadId
        }

//        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
//            startActivity(Intent(this, MainActivity::class.java))
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
    }

    override fun onStart() {
        super.onStart()
        DescriptionPresenter.attachScreen(this)
    }

    override fun onStop() {
        DescriptionPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        DescriptionPresenter.queryBreedDetails(breadId)
    }

    override fun showDescription(bread: DogBreadResult) {
        val nameText = "Name: " + bread.name
        val temperamentText = "Temperament: " + bread.temperament
        val lifespanText = "Lifespan: " + bread.life_span + " years"
        val originText = "Origin: " + bread.origin

        breadNameText.text = nameText
        breadTemperamentText.text = temperamentText
        breadLifeSpanText.text = lifespanText
        breadOriginText.text = originText

        DescriptionPresenter.queryBreedPicture(bread.image?.url)
    }

    override fun setImage(image: Drawable) {
        imageView.setImageDrawable(image)
    }

    override fun showError(errorMsg: String) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()
    }
}