package com.jshvarts.presentation

import com.jshvarts.model.Member

interface MembersView : BaseView {
    var isUpdating: Boolean
    fun onUpdate(members: List<Member>, organization: String)
}
