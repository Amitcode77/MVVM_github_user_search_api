package com.example.mvvm_github_user_search.data.repos

import com.example.mvvm_github_user_search.data.api.Client

object GithubRepository {

    suspend fun getUsers() = Client.api.getUsers()

    suspend fun searchUser(name:String) = Client.api.searchUsers(name)
}