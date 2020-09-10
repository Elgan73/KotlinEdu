package com.stark.kotlinedu.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.stark.kotlinedu.ui.MainViewModel
import com.stark.kotlinedu.R
import com.stark.kotlinedu.ui.adapters.NoteViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var adapter: NoteViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbarMain)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        adapter = NoteViewAdapter()
        recyclerView.adapter = adapter

        viewModel.getViewState().observe(this, Observer { value ->
            value?.let { adapter.notes = it.notes }
        })
    }


}