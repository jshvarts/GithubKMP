package com.jshvarts.api

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.Url

class GitHubApi {
    private val client = HttpClient()

    private val membersUrl = Url("https://api.github.com/orgs/raywenderlich/members")

    suspend fun getMembers(): String {
        val result: String = client.get {
            url(this@GitHubApi.membersUrl.toString())
        }
        return result
    }
}
