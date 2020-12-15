package com.zegnus.birthdaylist.businesslogic.domain

import com.soywiz.klock.DateTime

data class Birthday(val name: String, val date: DateTime, val sex: Sex)

enum class Sex {
    Male,
    Female,
    NotSpecified
}

interface BirthdayListRepository {

    fun birthdayList(): List<Birthday>
}
