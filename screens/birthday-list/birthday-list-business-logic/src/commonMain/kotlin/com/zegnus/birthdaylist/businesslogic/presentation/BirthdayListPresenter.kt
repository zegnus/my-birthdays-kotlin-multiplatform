package com.zegnus.birthdaylist.businesslogic.presentation

import com.zegnus.birthdaylist.businesslogic.domain.Birthday
import com.zegnus.birthdaylist.businesslogic.usecase.BirthdayListUseCase

class BirthdayListPresenter(
    private val birthdayListUseCase: BirthdayListUseCase,
    private val time: Time = TimeImp()
) {

    fun birthdaysList(): List<BirthdayViewModel> {
        return birthdayListUseCase.birthdayList()
            .map { it.toViewModel() }
    }

    private fun Birthday.toViewModel(): BirthdayViewModel {
        val remainingMonths = date.month1 - time.now().month1
        val text = "$name's birthday is in $remainingMonths months, " +
                "on the ${date.dayOfMonth}${date.dayOfMonth.toOrdinal()} ${date.month.localName}"
        return BirthdayViewModel(text)
    }

    fun Int.toOrdinal(): String {
        val hunRem = this % 100
        val tenRem = this % 10
        return if (hunRem - tenRem == 10) {
            "th"
        } else when (tenRem) {
            1 -> "st"
            2 -> "nd"
            3 -> "rd"
            else -> "th"
        }
    }
}
