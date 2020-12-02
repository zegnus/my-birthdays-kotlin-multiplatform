package com.zegnus.birthdaylist.ui

import androidx.lifecycle.ViewModel
import com.zegnus.birthdaylist.businesslogic.usecase.BirthdayListUseCase

class BirthdayListPresenter: ViewModel() {

    fun birthdaysList(): List<BirthdayViewModel> {
        return BirthdayListUseCase().birthdayList().map {
            BirthdayViewModel(it.name)
        }
    }
}

data class BirthdayViewModel(val text: String)
