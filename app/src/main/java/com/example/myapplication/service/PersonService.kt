package com.example.myapplication.service

import com.example.myapplication.entity.Person

object PersonService {

    val persons = mutableListOf<Person>(
        Person(1, "Ahmed", 20, null),
        Person(2, "Sara", 25, null),
        Person(3, "Youssef", 30, null)
    )

    fun getById(id: Int): Person? =
        persons.find { it.id == id }

    fun add(person: Person) {
        persons.add(person)
    }

    fun update(updatedPerson: Person) {
        val index = persons.indexOfFirst { it.id == updatedPerson.id }
        if (index != -1) {
            persons[index] = updatedPerson
        }
    }

    fun delete(person: Person) {
        persons.remove(person)
    }
}