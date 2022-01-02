package zar1official.broadcastreceiver.ui.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import zar1official.broadcastreceiver.data.receiver.Receiver
import zar1official.broadcastreceiver.data.storage.Storage
import zar1official.broadcastreceiver.domain.Note
import zar1official.broadcastreceiver.domain.NoteRepository

class NotesListViewModel(private val repository: NoteRepository) : ViewModel() {
    val notes: LiveData<ArrayList<Note>>
        get() = repository.getNotes()
}