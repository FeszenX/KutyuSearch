package com.example.kutyusearch.ui.breads

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kutyusearch.R
import com.example.kutyusearch.model.DogBread
import com.example.kutyusearch.ui.about.About
import com.example.kutyusearch.ui.breads.adapter.BreadAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BreadsScreen {

    lateinit var breadAdapter: BreadAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onStart() {
        super.onStart()
        BreadsPresenter.attachScreen(this)
    }

    override fun onStop() {
        BreadsPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        initRecyclerView()
        BreadsPresenter.queryBreads(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            openAboutActivity() -> true
            else -> false

        }
    }

    override fun showBreads(breadsList: List<DogBread>) {
        breadAdapter.setBreads(breadsList)
    }

    override fun showError(errorMsg: String) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()
    }

    private fun openAboutActivity(): Int {
        startActivity(Intent(this, About::class.java))
        return 1;
    }

    private fun initRecyclerView() {
        breadAdapter = BreadAdapter(this)
        listBreads.adapter = breadAdapter
    }
}