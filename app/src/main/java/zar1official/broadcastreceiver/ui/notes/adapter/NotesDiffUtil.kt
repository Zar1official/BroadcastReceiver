package zar1official.broadcastreceiver.ui.notes.adapter

import androidx.recyclerview.widget.DiffUtil
import zar1official.broadcastreceiver.domain.Note

class NotesDiffUtil(private val oldList: List<Note>, private val newList: List<Note>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].date == newList[newItemPosition].date

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldList[oldItemPosition]
        val new = newList[newItemPosition]
        return old.text == new.text && old.title == new.title && old.date == new.date
    }
}