package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.entity.Person
import com.example.myapplication.service.PersonService

class UpdatePersonActivity : AppCompatActivity() {

    private var selectedImage: String? = null
    private val PICK_IMAGE = 201

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_person)

        val id = intent.getIntExtra("id", -1)
        val person = PersonService.getById(id)

        if (person == null) {
            finish()
            return
        }

        val txtName = findViewById<EditText>(R.id.edtName)
        val txtAge = findViewById<EditText>(R.id.edtAge)
        val img = findViewById<ImageView>(R.id.imgPreview)
        val btnChoose = findViewById<Button>(R.id.btnChooseImage)
        val btnSave = findViewById<Button>(R.id.btnUpdate)

        txtName.setText(person.name)
        txtAge.setText(person.age.toString())

        if (person.imageUri != null)
            img.setImageURI(Uri.parse(person.imageUri))

        btnChoose.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE)
        }

        btnSave.setOnClickListener {
            person.name = txtName.text.toString()
            person.age = txtAge.text.toString().toInt()
            person.imageUri = selectedImage ?: person.imageUri

            PersonService.update(person)

            finish()
        }
    }

    override fun onActivityResult(req: Int, res: Int, data: Intent?) {
        super.onActivityResult(req, res, data)

        if (req == PICK_IMAGE && res == Activity.RESULT_OK) {
            val uri = data?.data
            selectedImage = uri.toString()
            findViewById<ImageView>(R.id.imgPreview).setImageURI(uri)
        }
    }
}