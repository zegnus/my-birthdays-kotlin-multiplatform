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
                //Birthday("Ferran", DateTime(1982, Month.May, 14), Sex.Male),
                //Birthday("Marc", DateTime(2000, Month.March, 1), Sex.Male)
            )
        )
        val birthdayList = presenter.birthdaysList()

        val expectedBirthdayList = listOf(
            BirthdayViewModel("Anna's birthday is today, she is 34 years old"),
            BirthdayViewModel("Eric's birthday is tomorrow, Eric will be 20 years old"),
            //BirthdayViewModel("Anna's birthday is in 4 months, on the 13th of July she will be 34 years old"),
            //BirthdayViewModel("Eric's birthday is in 10 months, on the 7th of January Eric will be 30 years old"),
            //BirthdayViewModel("Ferran's birthday is in 2 months, on the 14th of May he will be 39 years old"),
            //BirthdayViewModel("Marc's birthday is today, he is 20 years old")
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
