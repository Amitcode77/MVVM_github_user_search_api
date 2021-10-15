package com.example.mvvm_github_user_search.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_github_user_search.R
import com.example.mvvm_github_user_search.data.model.User
import com.example.mvvm_github_user_search.ui.adapter.UserAdapter
import com.example.mvvm_github_user_search.ui.viewmodel.GithubViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val vm by lazy {
        ViewModelProvider(this).get(GithubViewModel::class.java)
    }

    var list = mutableListOf<User>()
    var originalList = mutableListOf<User>()
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm.users.observe(this, Observer {
            rv_user.adapter = UserAdapter(it)
        })
        rv_user.layoutManager = LinearLayoutManager(this)

//        sv_search_users.isSubmitButtonEnabled = true
//        sv_search_users.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                query?.let {
//                    findUser(it)
//                }
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                newText?.let {
//                    findUser(it)
//                }
//                return true
//            }
//
//        })

//        sv_search_users.setOnCloseListener {
//            list.clear()
//            list.addAll(originalList)
//            //another way to do it is below method
////            vm.users.value?.let { list.addAll(it) }
//            adapter.notifyDataSetChanged()
//            return@setOnCloseListener true
//        }
    }

//    private fun findUser(query: String) {
//        vm.searchUsers(query).observe(this, Observer {
//            if(!list.isNullOrEmpty()){
//                list.clear()
//                list.addAll(it)
//                adapter.notifyDataSetChanged()
//                Log.d("check","inside find user")
//            }
//        })
//    }
}


