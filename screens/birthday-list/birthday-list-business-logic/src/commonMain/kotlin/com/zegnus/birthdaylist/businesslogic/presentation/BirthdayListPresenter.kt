package com.zegnus.birthdaylist.businesslogic.presentation

import com.zegnus.birthdaylist.businesslogic.usecase.BirthdayListUseCase

class BirthdayListPresenter(
    private val birthdayListUseCase: BirthdayListUseCase,
    private val time: Time = TimeImp()
) {

    fun birthdaysList(): List<BirthdayViewModel> {
        return birthdayListUseCase.birthdayList()
            .map { it.toViewModel(time) }
    }
}
