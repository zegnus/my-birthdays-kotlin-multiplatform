package com.zegnus.birthdaylist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class BirthdayListScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday_list)

        val birthdayListAdapter = setBirthdaysContentList()

        val birthdayListPresenter = birthdayListPresenter()
        val birthdaysList = birthdayListPresenter.birthdaysList()
        birthdayListAdapter.submitList(birthdaysList)
    }

    private fun birthdayListPresenter(): BirthdayListPresenter {
        val factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return BirthdayListPresenter() as T
            }
        }

        return ViewModelProvider(this, factory).get(BirthdayListPresenter::class.java)
    }

    private fun setBirthdaysContentList(): BirthdayListAdapter {
        val birthdayListRecyclerView: RecyclerView = findViewById(R.id.birthday_list)
        val birthdayListAdapter = BirthdayListAdapter()

        birthdayListRecyclerView.apply {
            adapter = birthdayListAdapter
        }
        return birthdayListAdapter
    }
}
