package com.jshvarts.api

import com.jshvarts.Keys.DEFAULT_ORGANIZATION
import com.jshvarts.Keys.ORGANIZATION_KEY
import com.jshvarts.model.Member
import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.Url
import kotlinx.serialization.json.Json
import kotlinx.serialization.list

private const val BASE_URL = "https://api.github.com/orgs"

class GitHubApi(private val settings: Settings) {
    private val client = HttpClient()

    suspend fun getMembers(): List<Member> {

        val organization = settings[ORGANIZATION_KEY, DEFAULT_ORGANIZATION]
        val membersUrl = Url("$BASE_URL/$organization/members")

        val result: String = client.get {
            url(membersUrl.toString())
        }

        return Json.nonstrict.parse(Member.serializer().list, result)
    }
}
