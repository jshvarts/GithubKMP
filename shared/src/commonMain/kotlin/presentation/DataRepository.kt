package com.jshvarts.presentation

import com.jshvarts.model.Member

interface DataRepository {
    val members: List<Member>?
    var onRefreshListeners: List<() -> Unit>

    suspend fun update()
}
