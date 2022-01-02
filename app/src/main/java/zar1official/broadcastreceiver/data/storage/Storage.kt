package zar1official.broadcastreceiver.data.storage

import androidx.lifecycle.MutableLiveData
import zar1official.broadcastreceiver.domain.Note

class Storage {

    val items = MutableLiveData<ArrayList<Note>>()

    companion object {

        @Volatile
        private var INSTANCE: Storage? = null

        fun getStorage() =
            INSTANCE ?: synchronized(this) {
                val instance = Storage()
                INSTANCE = instance
                instance
            }
    }
}