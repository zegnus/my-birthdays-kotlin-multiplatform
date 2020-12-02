package com.zegnus.birthdaylist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class BirthdayListScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday_list)

        val birthdayListRecyclerView: RecyclerView = findViewById(R.id.birthday_list)
        val birthdayListAdapter = BirthdayListAdapter()

        birthdayListRecyclerView.apply {
            adapter = birthdayListAdapter
        }

        birthdayListAdapter.submitList(birthdayListContent())
    }

    private fun birthdayListContent(): List<Birthday> {
        return listOf(
            Birthday("one"),
            Birthday("two"),
            Birthday("three"),
            Birthday("one"),
            Birthday("two"),
            Birthday("three"),
            Birthday("one"),
            Birthday("two"),
            Birthday("three"),
            Birthday("one"),
            Birthday("two"),
            Birthday("three"),
            Birthday("one"),
            Birthday("two"),
            Birthday("three"),
            Birthday("one"),
            Birthday("two"),
            Birthday("three"),
            Birthday("one"),
            Birthday("two"),
            Birthday("three"),
            Birthday("one"),
            Birthday("two"),
            Birthday("three"),
            Birthday("one"),
            Birthday("two"),
            Birthday("three"),
            Birthday("one"),
            Birthday("two"),
            Birthday("three"),
            Birthday("one"),
            Birthday("two"),
            Birthday("three"),
            Birthday("one"),
            Birthday("two"),
            Birthday("three"),
            Birthday("one"),
            Birthday("two"),
            Birthday("three"),
            Birthday("one"),
            Birthday("two"),
            Birthday("three"),
            Birthday("one"),
            Birthday("two"),
            Birthday("three"),
            Birthday("one"),
            Birthday("two"),
            Birthday("three"),
            Birthday("one"),
            Birthday("two"),
            Birthday("three"),
            Birthday("one"),
            Birthday("two")
        )
    }
}
