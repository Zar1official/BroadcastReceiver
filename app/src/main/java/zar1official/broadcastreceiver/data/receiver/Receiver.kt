package zar1official.broadcastreceiver.data.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.lifecycle.MutableLiveData
import zar1official.broadcastreceiver.domain.Note
import zar1official.broadcastreceiver.domain.NoteRepository

class Receiver(private val repository: NoteRepository) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let { data ->
            val note = Note(
                title = data.getStringExtra(TITLE_PARAM).orEmpty(),
                text = data.getStringExtra(TEXT_PARAM).orEmpty(),
                date = data.getLongExtra(DATE_PARAM, 0),
            )
            repository.saveNotes(note)
        }
    }

    companion object {
        private const val TITLE_PARAM = "title"
        private const val TEXT_PARAM = "text"
        private const val DATE_PARAM = "date"
    }
}