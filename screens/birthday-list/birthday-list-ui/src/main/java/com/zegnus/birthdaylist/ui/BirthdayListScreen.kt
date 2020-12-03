package com.zegnus.birthdaylist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.zegnus.birthdaylist.businesslogic.data.BirthdayListRepositoryImpl
import com.zegnus.birthdaylist.businesslogic.presentation.BirthdayListPresenter
import com.zegnus.birthdaylist.businesslogic.usecase.BirthdayListUseCase

class BirthdayListScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday_list)

        val birthdayListAdapter = setBirthdaysContentList()

        val birthdayListPresenter = BirthdayListPresenter(
            BirthdayListUseCase(BirthdayListRepositoryImpl())
        )
        val birthdaysList = birthdayListPresenter.birthdaysList()
        birthdayListAdapter.submitList(birthdaysList)
    }

//    private fun birthdayListPresenter(): BirthdayListPresenter {
//        val factory = object : ViewModelProvider.Factory {
//            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//                return BirthdayListPresenter() as T
//            }
//        }
//
//        return ViewModelProvider(this, factory).get(BirthdayListPresenter::class.java)
//    }

    private fun setBirthdaysContentList(): BirthdayListAdapter {
        val birthdayListRecyclerView: RecyclerView = findViewById(R.id.birthday_list)
        val birthdayListAdapter = BirthdayListAdapter()

        birthdayListRecyclerView.apply {
            adapter = birthdayListAdapter
        }
        return birthdayListAdapter
    }
}
