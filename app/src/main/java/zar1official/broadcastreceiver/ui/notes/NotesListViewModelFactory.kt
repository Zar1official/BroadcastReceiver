package zar1official.broadcastreceiver.ui.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import zar1official.broadcastreceiver.domain.NoteRepository

class NotesListViewModelFactory(private val repository: NoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = NotesListViewModel(repository) as T
}