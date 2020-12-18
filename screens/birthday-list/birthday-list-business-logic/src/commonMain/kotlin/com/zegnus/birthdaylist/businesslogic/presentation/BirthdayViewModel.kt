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
        WhenIsTheBirthdayType.Tomorrow -> "TODO()"
        WhenIsTheBirthdayType.NextDay -> "TODO()"
        WhenIsTheBirthdayType.ThisMonth -> "TODO()"
        WhenIsTheBirthdayType.NextMonth -> "TODO()"
        WhenIsTheBirthdayType.MoreThanAMonth -> "TODO()"
    }
    return BirthdayViewModel(text)
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
    Today, // Anna's birthday is today, she will is 34 years old
    Tomorrow, // Anna's birthday is tomorrow, she will be 34 years old
    NextDay, // Anna's birthday is next Tuesday on the 24th of January, she will is 34 years old
    ThisMonth, // Anna's birthday is this month on the 24th of January, she will is 34 years old
    NextMonth, // Anna's birthday is next month on the 24th of January, she will is 34 years old
    MoreThanAMonth, // Anna's birthday is in 2 months on the 24th of Jaunary, she will is 34 years old
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

//            BirthdayViewModel("Anna's birthday is today, she will is 34 years old"),
//            //BirthdayViewModel("Anna's birthday is in 4 months, on the 13th of July she will be 34 years old"),
//            //BirthdayViewModel("Eric's birthday is in 10 months, on the 7th of January Eric will be 30 years old"),
//            //BirthdayViewModel("Ferran's birthday is in 2 months, on the 14th of May he will be 39 years old"),
//            //BirthdayViewModel("Marc's birthday is today, he is 20 years old")
