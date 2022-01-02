package zar1official.broadcastreceiver.data.repositories

import androidx.lifecycle.LiveData
import zar1official.broadcastreceiver.data.storage.Storage
import zar1official.broadcastreceiver.domain.Note
import zar1official.broadcastreceiver.domain.NoteRepository

class NoteRepositoryImpl(private val storage: Storage) : NoteRepository {
    override fun getNotes(): LiveData<ArrayList<Note>> = storage.items

    override fun saveNotes(note: Note) {
        storage.items.value =
            storage.items.value?.apply { add(note) } ?: ArrayList<Note>().apply { add(note) }
    }
}