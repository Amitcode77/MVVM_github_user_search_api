package com.example.mvvm_github_user_search.data.api

import com.example.mvvm_github_user_search.data.model.SearchResponse
import com.example.mvvm_github_user_search.data.model.User
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("users")
    suspend fun getUsers():Response<List<User>>

    @GET("search/users")
    suspend fun searchUsers(@Query("q") name:String):Response<SearchResponse>

}
