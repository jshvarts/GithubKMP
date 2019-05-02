package com.jshvarts.presentation

import com.jshvarts.ApplicationDispatcher
import kotlinx.coroutines.launch

class MemberPresenter(
    private val view: MembersView,
    private val repository: DataRepository
) : CoroutinePresenter(ApplicationDispatcher, view) {

    private val onRefreshListener: () -> Unit = this::showData

    override fun onCreate() {
        view.isUpdating = isFirstDataLoading()
        repository.onRefreshListeners += onRefreshListener
        showData()
        updateData()
    }

    override fun onDestroy() {
        super.onDestroy()
        repository.onRefreshListeners -= onRefreshListener
    }

    private fun showData() {
        view.onUpdate(repository.members ?: "No members")
    }

    private fun updateData() {
        launch {
            repository.update()
            showData()
        }.invokeOnCompletion {
            view.isUpdating = false
        }
    }

    private fun isFirstDataLoading() = repository.members == null
}
