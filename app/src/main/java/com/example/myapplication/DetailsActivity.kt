package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.service.PersonService

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val txtDetails = findViewById<TextView>(R.id.txtDetails)
        val btnEdit = findViewById<Button>(R.id.btnEdit)
        val btnDelete = findViewById<Button>(R.id.btnDelete)

        val id = intent.getIntExtra("id", -1)

        if (id == -1) {
            txtDetails.text = "ID not received"
            return
        }

        val person = PersonService.getById(id)

        if (person == null) {
            txtDetails.text = "Person not found"
            return
        }

        txtDetails.text = "Name: ${person.name}\nAge: ${person.age}"

        btnEdit.setOnClickListener {
            val intent = Intent(this, UpdatePersonActivity::class.java)
            intent.putExtra("id", person.id)
            startActivity(intent)
            finish()
        }

        btnDelete.setOnClickListener {
            PersonService.delete(person)
            finish()
        }
    }
}