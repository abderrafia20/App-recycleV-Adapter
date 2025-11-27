package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.entity.Person
import com.example.myapplication.service.PersonService

class AddPersonActivity : AppCompatActivity() {

    private var selectedImage: String? = null
    private val PICK_IMAGE = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_person)

        val txtName = findViewById<EditText>(R.id.edtName)
        val txtAge = findViewById<EditText>(R.id.edtAge)
        val img = findViewById<ImageView>(R.id.imgPreview)
        val btnChoose = findViewById<Button>(R.id.btnChooseImage)
        val btnSave = findViewById<Button>(R.id.btnSave)

        btnChoose.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE)
        }

        btnSave.setOnClickListener {
            val id = PersonService.persons.size + 1
            val name = txtName.text.toString()
            val age = txtAge.text.toString().toInt()

            val p = Person(id, name, age, selectedImage)
            PersonService.add(p)

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