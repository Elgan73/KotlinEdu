package com.stark.kotlinedu.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*


object Repository {
    private val notesLiveData = MutableLiveData<List<Note>>()

    private val notes = mutableListOf(
        Note(
            UUID.randomUUID().toString(),
            "Заголовок 1",
            "У клиентского компонента нет соединения с запущенной службой.",
            Note.Color.YELLOW),
        Note(
            UUID.randomUUID().toString(),
            "Заголовок 2",
            "У клиентского компонента нет соединения с запущенной службой.",
            Note.Color.GREEN),
        Note(
            UUID.randomUUID().toString(),
            "Заголовок 3",
            "У клиентского компонента нет соединения с запущенной службой.",
            Note.Color.GREY),
        Note(
            UUID.randomUUID().toString(),
            "Заголовок 4",
            "У клиентского компонента нет соединения с запущенной службой.",
            Note.Color.PINK),
        Note(
            UUID.randomUUID().toString(),
            "Заголовок 5",
            "У клиентского компонента нет соединения с запущенной службой.",
            Note.Color.GREY),
        Note(
            UUID.randomUUID().toString(),
            "Заголовок 6",
            "У клиентского компонента нет соединения с запущенной службой.",
            Note.Color.VIOLET),
        Note(
            UUID.randomUUID().toString(),
            "Заголовок 7",
            "У клиентского компонента нет соединения с запущенной службой.",
            Note.Color.WHITE),
        Note(
            UUID.randomUUID().toString(),
            "Заголовок 8",
            "У клиентского компонента нет соединения с запущенной службой.",
            Note.Color.GREEN),
        Note(
            UUID.randomUUID().toString(),
            "Заголовок 9",
            "У клиентского компонента нет соединения с запущенной службой.",
            Note.Color.YELLOW),
        Note(
            UUID.randomUUID().toString(),
            "Заголовок 10",
            "У клиентского компонента нет соединения с запущенной службой.",
            Note.Color.VIOLET),
        Note(
            UUID.randomUUID().toString(),
            "Заголовок 11",
            "У клиентского компонента нет соединения с запущенной службой.",
            Note.Color.GREY),
        Note(
            UUID.randomUUID().toString(),
            "Заголовок 12",
            "У клиентского компонента нет соединения с запущенной службой.",
            Note.Color.PINK),
        Note(
            UUID.randomUUID().toString(),
            "Заголовок 13",
            "У клиентского компонента нет соединения с запущенной службой.",
            Note.Color.WHITE),
        Note(
            UUID.randomUUID().toString(),
            "Заголовок 14",
            "У клиентского компонента нет соединения с запущенной службой.",
            Note.Color.GREEN)
    )

    init {
        notesLiveData.value = notes
    }

    fun getNotes() : LiveData<List<Note>> {
        return notesLiveData
    }

    fun saveNote(note : Note) {
        addOrReplace(note)
        notesLiveData.value = notes
    }

    private fun addOrReplace(note:Note) {
        for(i in 0 until notes.size ) {
            if(notes[i] == note) {
                notes[i] = note
                return
            }
        }
        notes.add(note)
    }

}