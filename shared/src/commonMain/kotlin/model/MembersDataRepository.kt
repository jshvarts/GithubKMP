package com.jshvarts.api.model

import com.jshvarts.api.GitHubApi
import com.jshvarts.api.UpdateProblem
import com.jshvarts.model.Member
import com.jshvarts.presentation.DataRepository

class MembersDataRepository(private val api: GitHubApi) : DataRepository {
    override var members: List<Member>? = null

    override var onRefreshListeners: List<() -> Unit> = emptyList()

    override suspend fun update() {
        val newMembers = try {
            api.getMembers()
        } catch (cause: Throwable) {
            throw UpdateProblem()
        }

        if (newMembers != members) {
            members = newMembers
            callRefreshListeners()
        }
    }

    private fun callRefreshListeners() {
        onRefreshListeners.forEach { it.invoke() }
    }
}
