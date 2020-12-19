package com.zegnus.birthdaylist.businesslogic.data

import com.soywiz.klock.DateTime
import com.soywiz.klock.Month
import com.zegnus.birthdaylist.businesslogic.domain.Birthday
import com.zegnus.birthdaylist.businesslogic.domain.BirthdayListRepository
import com.zegnus.birthdaylist.businesslogic.domain.Sex

class BirthdayListRepositoryImpl: BirthdayListRepository {

    override fun birthdayList(): List<Birthday> {
        return listOf(
            Birthday("Anna", DateTime(1987, Month.July, 13), Sex.Female),
            Birthday("Ferran", DateTime(1982, Month.May, 14), Sex.Male),
            Birthday("Adrian", DateTime(2020, Month.August, 29), Sex.Male)
        )
    }
}
