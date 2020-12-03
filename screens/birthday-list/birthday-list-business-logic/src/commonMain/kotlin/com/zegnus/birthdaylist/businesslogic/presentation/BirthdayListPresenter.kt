package com.zegnus.birthdaylist.businesslogic.presentation

import com.zegnus.birthdaylist.businesslogic.domain.Birthday
import com.zegnus.birthdaylist.businesslogic.usecase.BirthdayListUseCase

class BirthdayListPresenter(private val birthdayListUseCase: BirthdayListUseCase) {

    fun birthdaysList(): List<BirthdayViewModel> {
        return birthdayListUseCase.birthdayList()
            .map { it.toViewModel() }
    }
}

private fun Birthday.toViewModel(): BirthdayViewModel {
    return BirthdayViewModel(name)
}
