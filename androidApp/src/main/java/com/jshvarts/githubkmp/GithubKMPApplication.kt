package com.jshvarts.githubkmp

import android.app.Application
import com.jshvarts.UserSettings
import com.jshvarts.api.GitHubApi
import com.jshvarts.api.model.MembersDataRepository
import com.jshvarts.presentation.DataRepository
import com.russhwolf.settings.Settings

class GithubKMPApplication : Application() {
    val settings: Settings by lazy {
        UserSettings().userSettings(this)
    }

    val dataRepository: DataRepository by lazy {
        MembersDataRepository(GitHubApi(settings))
    }
}
