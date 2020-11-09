package com.stark.kotlinedu.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.stark.kotlinedu.R
import com.stark.kotlinedu.ui.note.NoteActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var adapter: NoteViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        adapter = NoteViewAdapter {
            NoteActivity.start(this, it)
        }

        recyclerView.adapter = adapter

        viewModel.getViewState().observe(this, Observer { value ->
            value?.let { adapter.notes = it.notes }
        })

        fab.setOnClickListener {
            NoteActivity.start(this)
        }
    }


}