package zar1official.broadcastreceiver.ui.notes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import zar1official.broadcastreceiver.R
import zar1official.broadcastreceiver.databinding.NoteItemBinding
import zar1official.broadcastreceiver.domain.Note
import zar1official.broadcastreceiver.util.DateTimeUtils

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    val items = ArrayList<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder =
        NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        )

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = NoteItemBinding.bind(itemView)

        fun bind(note: Note) = with(binding) {
            noteTitle.text = note.title
            noteContent.text = note.text
            noteDate.text = DateTimeUtils.millisToDateTime(note.date)
        }
    }

    fun updateList(newList: List<Note>) {
        val diffCallback = NotesDiffUtil(items, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items.clear()
        items.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
}