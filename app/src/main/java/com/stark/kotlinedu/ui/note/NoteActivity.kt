package com.stark.kotlinedu.ui.note

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import com.stark.kotlinedu.R
import com.stark.kotlinedu.model.Note
import kotlinx.android.synthetic.main.activity_note.*
import java.text.SimpleDateFormat
import java.util.*

class NoteActivity : AppCompatActivity() {

    companion object {
        private const val NOTE_KEY = "note"
        private const val DATA_FORMAT = "dd.MM.yy HH:mm"

        fun start(context: Context, note: Note? = null) = Intent(context, NoteActivity::class.java).apply {
            putExtra(NOTE_KEY, note)
            context.startActivity(this)
        }
    }

    private var note: Note? = null
    lateinit var viewModel: NoteViewModel

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            saveNote()
        }
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        note = intent.getParcelableExtra(NOTE_KEY)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        supportActionBar?.title = note?.let {
            SimpleDateFormat(DATA_FORMAT, Locale.getDefault()).format(it.lastChange)
        } ?: getString(R.string.new_note)

        initView()
    }

    private fun initView() {
        note?.let {
            title_text.setText(it.title)
            body_text.setText(it.text)
            val color = when (it.color) {
                Note.Color.WHITE -> R.color.WHITE
                Note.Color.PINK -> R.color.PINK
                Note.Color.YELLOW -> R.color.YELLOW
                Note.Color.GREY -> R.color.GREY
                Note.Color.VIOLET -> R.color.VIOLET
                Note.Color.GREEN -> R.color.GREEN
            }
            toolbar?.setBackgroundColor(ResourcesCompat.getColor(resources, color, null))
        }

        title_text.addTextChangedListener(textWatcher)
        body_text.addTextChangedListener(textWatcher)
    }

    private fun saveNote() {
        title_text.text?.let {
            if (it.length < 3) return
        } ?: return

        note = note?.copy(
            title = title_text.text.toString(),
            text = body_text.text.toString(),
            lastChange = Date()
        ) ?: Note(UUID.randomUUID().toString(), title_text.text.toString(), body_text.text.toString())

        note?.let {viewModel.save(it)}
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}