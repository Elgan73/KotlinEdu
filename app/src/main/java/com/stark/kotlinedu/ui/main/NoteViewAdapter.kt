package com.stark.kotlinedu.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.stark.kotlinedu.R
import com.stark.kotlinedu.model.Note
import kotlinx.android.synthetic.main.rv_item.view.*

class NoteViewAdapter(val onItemClick : ((Note) -> Unit)? = null) : RecyclerView.Adapter<NoteViewAdapter.NoteViewHolder>() {

    var notes: List<Note> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false))

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) = holder.bind(notes[position])

    inner class NoteViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(note : Note) = with(itemView as CardView) {
                titleText.text = note.title
                body.text = note.text

                val color = when (note.color) {
                    Note.Color.WHITE -> R.color.WHITE
                    Note.Color.PINK -> R.color.PINK
                    Note.Color.YELLOW -> R.color.YELLOW
                    Note.Color.GREY -> R.color.GREY
                    Note.Color.VIOLET -> R.color.VIOLET
                    Note.Color.GREEN -> R.color.GREEN
                }
                setCardBackgroundColor(ContextCompat.getColor(itemView.context, color))

                itemView.setOnClickListener{
                    onItemClick?.invoke(note)
                }
            }
    }
}