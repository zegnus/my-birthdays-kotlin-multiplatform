package com.zegnus.birthdaylist.businesslogic.presentation

import com.soywiz.klock.DateTime
import com.soywiz.klock.Month
import com.zegnus.birthdaylist.businesslogic.domain.Birthday
import com.zegnus.birthdaylist.businesslogic.domain.BirthdayListRepository
import com.zegnus.birthdaylist.businesslogic.usecase.BirthdayListUseCase
import kotlin.test.Test
import kotlin.test.assertEquals

class BirthdayListPresenterTest {

    private val now = DateTime(2020, Month.February, 1)

    @Test
    fun testExample() {
        val presenter = given(
            birthdayLit = listOf(Birthday("Anna", DateTime(1987, Month.July, 13)))
        )
        val birthdayList = presenter.birthdaysList()

        val expectedBirthdayList =
            listOf(BirthdayViewModel("Anna's birthday is in 5 months, on the 13th July"))

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
