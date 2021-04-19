package com.example.kutyusearch.ui.breads.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kutyusearch.R
import com.example.kutyusearch.model.DogBread
import com.example.kutyusearch.ui.description.DogDescription
import kotlinx.android.synthetic.main.bread_row.view.*

class BreadAdapter: RecyclerView.Adapter<BreadAdapter.ViewHolder> {
    val context: Context
    var breadList = mutableListOf<DogBread>()

    constructor(context: Context) {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.bread_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return breadList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bread = breadList[position]
        holder.lineBreadName.text = bread.name

        holder.cardView.setOnClickListener {
            val intent = Intent(context, DogDescription::class.java)
            intent.putExtra("BREAD_ID", bread.id)
            context.startActivity(intent)
        }
    }

    fun setBreads(breads: List<DogBread>) {
        this.breadList.clear()
        this.breadList.addAll(breads)
        notifyDataSetChanged()
    }

    inner class ViewHolder(breadView: View) : RecyclerView.ViewHolder(breadView) {
        val lineBreadName = breadView.lineBreadName
        val cardView = breadView.cardView
    }
}