package com.zegnus.birthdaylist.businesslogic.usecase

import com.zegnus.birthdaylist.businesslogic.domain.Birthday
import com.zegnus.birthdaylist.businesslogic.domain.BirthdayListRepository

class BirthdayListUseCase(private val birthdayListRepository: BirthdayListRepository) {

    fun birthdayList(): List<Birthday> {
        return birthdayListRepository.birthdayList()
    }
}
