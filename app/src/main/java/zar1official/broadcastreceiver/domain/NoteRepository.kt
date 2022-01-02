package zar1official.broadcastreceiver.domain

import androidx.lifecycle.LiveData

interface NoteRepository {
    fun getNotes(): LiveData<ArrayList<Note>>
    fun saveNotes(note: Note)
}