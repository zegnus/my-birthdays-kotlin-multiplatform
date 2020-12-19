package com.zegnus.birthdaylist.businesslogic.usecase

import com.soywiz.klock.DateTime
import com.soywiz.klock.TimeSpan
import com.zegnus.birthdaylist.businesslogic.domain.Birthday
import com.zegnus.birthdaylist.businesslogic.domain.BirthdayListRepository
import com.zegnus.birthdaylist.businesslogic.presentation.Time
import com.zegnus.birthdaylist.businesslogic.presentation.TimeImp

class BirthdayListUseCase(
    private val birthdayListRepository: BirthdayListRepository,
    private val time: Time = TimeImp()
) {

    fun birthdayList(): List<Birthday> =
        birthdayListRepository.birthdayList().sortedBy { timeDifference(time.now(), it.date) }
}

private fun timeDifference(now: DateTime, birthday: DateTime): Double {
    val birthdayThisYear = birthday.copyDayOfMonth(year = now.year)

    val diff = birthdayThisYear.minus(now)

    return if (diff.days < 0) {
        val nextYear = birthdayThisYear.copyDayOfMonth(year = now.year + 1)
        nextYear.minus(now).days
    } else {
        diff.days
    }
}