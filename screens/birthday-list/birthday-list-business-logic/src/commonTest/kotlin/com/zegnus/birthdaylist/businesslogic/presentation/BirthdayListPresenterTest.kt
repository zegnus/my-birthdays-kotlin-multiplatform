package com.zegnus.birthdaylist.businesslogic.presentation

import com.soywiz.klock.DateTime
import com.soywiz.klock.Month
import com.zegnus.birthdaylist.businesslogic.domain.Birthday
import com.zegnus.birthdaylist.businesslogic.domain.BirthdayListRepository
import com.zegnus.birthdaylist.businesslogic.domain.Sex
import com.zegnus.birthdaylist.businesslogic.usecase.BirthdayListUseCase
import kotlin.test.Test
import kotlin.test.assertEquals

class BirthdayListPresenterTest {

    private val now = DateTime(2020, Month.March, 1)

    @Test
    fun testExample() {
        val presenter = given(
            listOf(
                Birthday("Anna", DateTime(1987, Month.March, 1), Sex.Female),
                Birthday("Eric", DateTime(1990, Month.March, 2), Sex.NotSpecified),
                Birthday("Josep", DateTime(1982, Month.March, 3), Sex.Male),
                Birthday("Laura", DateTime(1982, Month.March, 7), Sex.Female),
                Birthday("Carlos", DateTime(1982, Month.March, 8), Sex.Male),
                Birthday("Marc", DateTime(1982, Month.March, 9), Sex.Male),
                Birthday("Marta", DateTime(1982, Month.April, 1), Sex.NotSpecified),
                Birthday("David", DateTime(1982, Month.May, 1), Sex.Male),
                Birthday("Jordi", DateTime(1982, Month.February, 1), Sex.Male)
            )
        )
        val birthdayList = presenter.birthdaysList()

        val expectedBirthdayList = listOf(
            BirthdayViewModel("Anna's birthday is today, she is 34 years old"),
            BirthdayViewModel("Eric's birthday is tomorrow, Eric will be 31 years old"),
            BirthdayViewModel("Josep's birthday is next Wednesday on the 3rd of March, he will be 39 years old"),
            BirthdayViewModel("Laura's birthday is next Sunday on the 7th of March, she will be 39 years old"),
            BirthdayViewModel("Carlos's birthday is next Monday on the 8th of March, he will be 39 years old"),
            BirthdayViewModel("Marc's birthday is this month on the 9th of March, he will be 39 years old"),
            BirthdayViewModel("Marta's birthday is next month on the 1st of April, Marta will be 39 years old"),
            BirthdayViewModel("David's birthday is in 2 months on the 1st of May, he will be 39 years old"),
            BirthdayViewModel("Jordi's birthday is in 10 months on the 1st of February, he will be 39 years old")
        )

        assertEquals(expectedBirthdayList, birthdayList)
    }

    private fun given(birthdayLit: List<Birthday>): BirthdayListPresenter {
        val repository = object : BirthdayListRepository {
            override fun birthdayList(): List<Birthday> = birthdayLit
        }
        val useCase = BirthdayListUseCase(repository)

        return BirthdayListPresenter(useCase, StaticTime(now))
    }
}

private class StaticTime(private val now: DateTime) : Time {

    override fun now(): DateTime = now
}
