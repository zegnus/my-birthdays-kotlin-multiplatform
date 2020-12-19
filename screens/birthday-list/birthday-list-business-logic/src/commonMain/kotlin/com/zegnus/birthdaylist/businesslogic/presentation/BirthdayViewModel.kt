package com.zegnus.birthdaylist.businesslogic.presentation

import com.soywiz.klock.DateTime
import com.soywiz.klock.TimeSpan
import com.zegnus.birthdaylist.businesslogic.domain.Birthday
import com.zegnus.birthdaylist.businesslogic.domain.Sex
import com.zegnus.birthdaylist.businesslogic.presentation.WhenIsTheBirthdayType.*

data class BirthdayViewModel(val text: String)

internal fun Birthday.toViewModel(time: Time): BirthdayViewModel {
    val whenIsTheBirthdayType = whenIsTheBirthdayType(time.now())
    val yearsOld: Int = time.now().year - date.year + 1

    val text = when (whenIsTheBirthdayType) {
        Today -> "$name's birthday is today, ${personReference()} is $yearsOld years old"
        Tomorrow -> "$name's birthday is tomorrow, ${personWillBeXYearsOld(yearsOld)}"
        NextDay -> "$name's birthday is next ${date.dayOfWeek} ${birthdayDate(yearsOld)}"
        ThisMonth -> "$name's birthday is this month ${birthdayDate(yearsOld)}"
        NextMonth -> "$name's birthday is next month ${birthdayDate(yearsOld)}"
        MoreThanAMonth -> "$name's birthday is in ${monthsLeft(time.now())} months ${birthdayDate(yearsOld)}"
    }
    return BirthdayViewModel(text)
}

private fun Birthday.whenIsTheBirthdayType(now: DateTime): WhenIsTheBirthdayType =
    timeDifference(now, date).let {
        when {
            it.days.toInt() == 0 -> Today
            it.days.toInt() == 1 -> Tomorrow
            it.days.toInt() <= 7 -> NextDay
            date.month0 - now.month0 == 0 -> ThisMonth
            date.month0 - now.month0 == 1 -> NextMonth
            else -> MoreThanAMonth
        }
    }

private fun timeDifference(now: DateTime, birthday: DateTime): TimeSpan {
    val birthdayThisYear = birthday.copyDayOfMonth(year = now.year)

    val diff = birthdayThisYear.minus(now)

    return if (diff.days < 0) {
        val nextYear = birthdayThisYear.copyDayOfMonth(year = now.year + 1)
        nextYear.minus(now)
    } else {
        diff
    }
}

private enum class WhenIsTheBirthdayType {
    Today,
    Tomorrow,
    NextDay,
    ThisMonth,
    NextMonth,
    MoreThanAMonth,
}

private fun Birthday.personReference(): String =
    when (sex) {
        Sex.Male -> "he"
        Sex.Female -> "she"
        Sex.NotSpecified -> name
    }

private fun Birthday.personWillBeXYearsOld(yearsOld: Int) =
    "${personReference()} will be $yearsOld years old"

private fun Birthday.birthdayDate(yearsOld: Int) =
    "on the ${date.dayOfMonth}${date.dayOfMonth.toOrdinal()} of ${date.month}, " +
            personWillBeXYearsOld(yearsOld)

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

private fun Birthday.monthsLeft(today: DateTime): Int =
    if (date.month > today.month) {
        date.month - today.month
    } else {
        12 - today.month1 + date.month0
    }
