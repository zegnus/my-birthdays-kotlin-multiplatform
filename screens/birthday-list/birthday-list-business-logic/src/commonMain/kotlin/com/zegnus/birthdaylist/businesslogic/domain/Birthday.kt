package com.zegnus.birthdaylist.businesslogic.domain

import com.soywiz.klock.DateTime

data class Birthday(val name: String, val date: DateTime)

interface BirthdayListRepository {

    fun birthdayList(): List<Birthday>
}
