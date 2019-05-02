package com.jshvarts.presentation

interface MembersView : BaseView {
    var isUpdating: Boolean
    fun onUpdate(members: String)
}
