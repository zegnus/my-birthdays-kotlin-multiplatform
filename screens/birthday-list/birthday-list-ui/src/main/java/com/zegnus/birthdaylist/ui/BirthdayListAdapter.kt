package com.zegnus.birthdaylist.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class BirthdayListAdapter :
    ListAdapter<Birthday, BirthdayViewHolder>(BirthdayListDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirthdayViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.birthday_list_item, parent, false)

        return BirthdayViewHolder(view)
    }

    override fun onBindViewHolder(holder: BirthdayViewHolder, position: Int) {
        val birthday = getItem(position)
        holder.bind(birthday)
    }

}

data class Birthday(val text: String)

class BirthdayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val birthdayText: TextView = itemView.findViewById(R.id.birthday_text)

    fun bind(birthday: Birthday) {
        birthdayText.text = birthday.text
    }
}

object BirthdayListDiffCallback : DiffUtil.ItemCallback<Birthday>() {
    override fun areItemsTheSame(oldItem: Birthday, newItem: Birthday): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Birthday, newItem: Birthday): Boolean {
        return oldItem.text == newItem.text
    }
}
