package zar1official.broadcastreceiver.ui.notes

import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import zar1official.broadcastreceiver.application.App
import zar1official.broadcastreceiver.ui.notes.adapter.NotesAdapter
import zar1official.broadcastreceiver.data.receiver.Receiver
import zar1official.broadcastreceiver.data.repositories.NoteRepositoryImpl
import zar1official.broadcastreceiver.databinding.FragmentNotesListBinding
import zar1official.broadcastreceiver.domain.NoteRepository

class NotesListFragment : Fragment() {

    private var _binding: FragmentNotesListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NotesListViewModel by viewModels { NotesListViewModelFactory(repository) }
    private val repository: NoteRepository by lazy { NoteRepositoryImpl(App.instance.storage) }
    private val noteAdapter by lazy { NotesAdapter() }
    private val receiver by lazy { Receiver(repository) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotesListBinding.inflate(inflater, container, false).apply {
            notesRcView.layoutManager =
                StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL)
            notesRcView.adapter = noteAdapter
            viewModel.notes.observe(this@NotesListFragment) { notes ->
                noteAdapter.updateList(notes)
            }
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        activity?.registerReceiver(receiver, IntentFilter().apply { addAction(ACTION) })
    }

    override fun onPause() {
        super.onPause()
        activity?.unregisterReceiver(receiver)
    }

    companion object {
        private const val SPAN_COUNT = 2
        private const val ACTION = "com.zar1official.simplenote.action_note_saved"

        @JvmStatic
        fun newInstance() = NotesListFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}