package com.zegnus.birthdaylist.businesslogic.presentation

import com.zegnus.birthdaylist.businesslogic.domain.Birthday
import com.zegnus.birthdaylist.businesslogic.domain.Sex

data class BirthdayViewModel(val text: String)

internal fun Birthday.toViewModel(time: Time): BirthdayViewModel {
//    val remainingMonths = remainingMonths(time)
//    val whenIsTheBirthdayType = whenIsTheBirthday(date, time.now())
//    val whenIsTheBirthdayText = "whenIsTheBirthdayType.toText()"
//
//    val text = "$name's birthday is $whenIsTheBirthdayText, " +
//            "on the ${date.dayOfMonth}${date.dayOfMonth.toOrdinal()} of ${date.month} " +
//            "${personReference()} will be ${yearsOldNumber(time)} years old"
//    return BirthdayViewModel(text)
    return BirthdayViewModel("text")
}

private fun Birthday.personReference(): String =
    when (sex) {
        Sex.Male -> "he"
        Sex.Female -> "she"
        Sex.NotSpecified -> name
    }

private enum class WhenIsTheBirthdayType {
    Today,
    Tomorrow,
    ThisWeek,
    NextWeek,
    InTwoWeeks,
    ThisMonth,
    NextMonth,
    InMoreThanAMonth
}

private fun Int.toOrdinal(): String {
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
