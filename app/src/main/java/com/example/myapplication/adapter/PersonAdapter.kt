package com.example.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.DetailsActivity
import com.example.myapplication.R
import com.example.myapplication.entity.Person

class PersonAdapter(
    private val context: Context,
    private val persons: List<Person>
) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtName: TextView = view.findViewById(R.id.txtName)
        val txtAge: TextView = view.findViewById(R.id.txtAge)
        val imgPerson: ImageView = view.findViewById(R.id.imgPerson)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int = persons.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = persons[position]

        holder.txtName.text = person.name
        holder.txtAge.text = "Age: ${person.age}"


        val imageView = holder.itemView.findViewById<ImageView>(R.id.imgPerson)

        if (person.imageUri != null) {
            Glide.with(context)
                .load(person.imageUri)
                .circleCrop()
                .into(imageView)
        } else {
            imageView.setImageResource(R.drawable.ic_launcher_background)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("id", person.id)
            context.startActivity(intent)
        }
    }
}