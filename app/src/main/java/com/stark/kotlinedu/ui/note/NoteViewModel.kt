package com.stark.kotlinedu.ui.note

import androidx.lifecycle.ViewModel
import com.stark.kotlinedu.model.Note
import com.stark.kotlinedu.model.Repository

class NoteViewModel : ViewModel() {

    private var pendingNote: Note? = null

    fun save (note : Note) {
        pendingNote = note
    }

    override fun onCleared() {
        pendingNote?.let {
            Repository.saveNote(it)
        }
    }


}