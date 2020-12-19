package com.zegnus.birthdaylist.businesslogic.presentation

import com.soywiz.klock.DateTime
import com.soywiz.klock.TimeSpan
import com.soywiz.klock.Year
import com.zegnus.birthdaylist.businesslogic.domain.Birthday
import com.zegnus.birthdaylist.businesslogic.domain.Sex

data class BirthdayViewModel(val text: String)

internal fun Birthday.toViewModel(time: Time): BirthdayViewModel {
    val whenIsTheBirthdayType = whenIsTheBirthdayType(date, time.now())
    val yearsOld: Int = time.now().year - date.year + 1

    val text = when (whenIsTheBirthdayType) {
        WhenIsTheBirthdayType.Today -> "$name's birthday is today, ${personReference()} is $yearsOld years old"
        WhenIsTheBirthdayType.Tomorrow -> "$name's birthday is tomorrow, ${personReference()} will be $yearsOld years old"
        WhenIsTheBirthdayType.NextDay -> "$name's birthday is next ${date.dayOfWeek} on the ${date.dayOfMonth}${date.dayOfMonth.toOrdinal()} of ${date.month}, ${personReference()} will be $yearsOld years old"
        WhenIsTheBirthdayType.ThisMonth -> "$name's birthday is this month on the ${date.dayOfMonth}${date.dayOfMonth.toOrdinal()} of ${date.month}, ${personReference()} will be $yearsOld years old"
        WhenIsTheBirthdayType.NextMonth -> "$name's birthday is next month on the ${date.dayOfMonth}${date.dayOfMonth.toOrdinal()} of ${date.month}, ${personReference()} will be $yearsOld years old"
        WhenIsTheBirthdayType.MoreThanAMonth -> "$name's birthday is in ${monthsLeft(date, time.now())} months on the ${date.dayOfMonth}${date.dayOfMonth.toOrdinal()} of ${date.month}, ${personReference()} will be $yearsOld years old"
    }
    return BirthdayViewModel(text)
}

private fun monthsLeft(birthdayDate: DateTime, today: DateTime): Int =
    if (birthdayDate.month > today.month) {
        birthdayDate.month - today.month
    } else {
        12 - today.month1 + birthdayDate.month0
    }

private fun whenIsTheBirthdayType(birthday: DateTime, now: DateTime): WhenIsTheBirthdayType {
    val timeDifference = timeDifference(now, birthday)
    return when {
        timeDifference.days.toInt() == 0 -> WhenIsTheBirthdayType.Today
        timeDifference.days.toInt() == 1 -> WhenIsTheBirthdayType.Tomorrow
        timeDifference.days.toInt() <= 7 -> WhenIsTheBirthdayType.NextDay
        birthday.month0 - now.month0 == 0 -> WhenIsTheBirthdayType.ThisMonth
        birthday.month0 - now.month0 == 1 -> WhenIsTheBirthdayType.NextMonth
        else -> WhenIsTheBirthdayType.MoreThanAMonth
    }
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
    NextDay,
    ThisMonth,
    NextMonth,
    MoreThanAMonth,
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