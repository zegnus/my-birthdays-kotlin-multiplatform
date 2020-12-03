package com.zegnus.birthdaylist.businesslogic.data

import com.soywiz.klock.DateTime
import com.soywiz.klock.Month
import com.zegnus.birthdaylist.businesslogic.domain.Birthday
import com.zegnus.birthdaylist.businesslogic.domain.BirthdayListRepository

class BirthdayListRepositoryImpl: BirthdayListRepository {

    override fun birthdayList(): List<Birthday> {
        return listOf(
            Birthday("Anna", DateTime(1987, Month.July, 13)),
            Birthday("Ferran", DateTime(1982, Month.May, 14))
        )
    }
}