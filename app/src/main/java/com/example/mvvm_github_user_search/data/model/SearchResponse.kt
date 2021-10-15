package com.example.mvvm_github_user_search.data.model

data class SearchResponse(
    val incomplete_results: Boolean,
    val items: List<User>,
    val total_count: Int
)