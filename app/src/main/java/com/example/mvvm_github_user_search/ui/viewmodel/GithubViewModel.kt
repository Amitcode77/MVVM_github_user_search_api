package com.example.mvvm_github_user_search.ui.viewmodel

import androidx.lifecycle.*
import com.example.mvvm_github_user_search.data.model.User
import com.example.mvvm_github_user_search.data.repos.GithubRepository
import kotlinx.coroutines.*

class GithubViewModel : ViewModel() {

    val users = MutableLiveData<List<User>>()
    val searchUsers = MutableLiveData<List<User>>()

    init{
        fetchUsers()
    }

    private fun fetchUsers() = viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                GithubRepository.getUsers()
            }
            if (response.isSuccessful) {
                response.body()?.let {
                    users.postValue(it)
                }
            }
        }



    fun searchUsers(name:String) = viewModelScope.launch {
            val response = withContext(Dispatchers.IO){
                GithubRepository.searchUser(name)}
            if (response.isSuccessful){
                response.body()?.let {
                    searchUsers.postValue(it.items)      //emit gives the value of the live data
                }
            }
    }
}


/** Extension function for ViewModel Scope */
fun ViewModel.runIO(dispatcher: CoroutineDispatcher = Dispatchers.IO,function: suspend CoroutineScope.() -> Unit){
    viewModelScope.launch {
        function()  //to add  functionality to write code within launch of created extension function, we have written hgher order funcion in parameter and called that function
    }
}