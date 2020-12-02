package com.zegnus.birthdaylist.businesslogic.usecase

import com.soywiz.klock.DateTime
import com.soywiz.klock.Month
import com.zegnus.birthdaylist.businesslogic.domain.Birthday

class BirthdayListUseCase {

    fun birthdayList(): List<Birthday> {
        return listOf(
            Birthday("Anna", DateTime(1987, Month.July, 13)),
            Birthday("Ferran", DateTime(1982, Month.May, 14))
        )
    }
}
