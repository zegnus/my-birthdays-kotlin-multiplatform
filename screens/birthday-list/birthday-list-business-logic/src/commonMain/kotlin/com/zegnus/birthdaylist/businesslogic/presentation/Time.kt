package com.zegnus.birthdaylist.businesslogic.presentation

import com.soywiz.klock.DateTime

interface Time {

    fun now(): DateTime
}

class TimeImp: Time {

    override fun now(): DateTime = DateTime.now()
}
