package com.zegnus.birthdaylist.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zegnus.birthdaylist.businesslogic.presentation.BirthdayViewModel

class BirthdayListAdapter :
    ListAdapter<BirthdayViewModel, BirthdayViewHolder>(BirthdayListDiffCallback) {

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

class BirthdayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val birthdayText: TextView = itemView.findViewById(R.id.birthday_text)

    fun bind(birthdayViewModel: BirthdayViewModel) {
        birthdayText.text = birthdayViewModel.text
    }
}

object BirthdayListDiffCallback : DiffUtil.ItemCallback<BirthdayViewModel>() {
    override fun areItemsTheSame(oldItem: BirthdayViewModel, newItem: BirthdayViewModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: BirthdayViewModel, newItem: BirthdayViewModel): Boolean {
        return oldItem.text == newItem.text
    }
}
