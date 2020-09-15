package com.stark.kotlinedu.ui.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stark.kotlinedu.R
import com.stark.kotlinedu.model.Note
import kotlinx.android.synthetic.main.rv_item.view.*

class NoteViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun bind(note : Note) =
        with(itemView) {
            titleText.text = note.title
            body.text = note.text
            cardLiner.setBackgroundColor(note.color)
        }



}