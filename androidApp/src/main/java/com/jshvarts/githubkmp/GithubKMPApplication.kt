package com.jshvarts.githubkmp

import android.app.Application
import com.jshvarts.api.GitHubApi
import com.jshvarts.api.model.MembersDataRepository
import com.jshvarts.presentation.DataRepository

class GithubKMPApplication : Application() {
    val dataRepository: DataRepository by lazy {
        MembersDataRepository(GitHubApi())
    }
}
