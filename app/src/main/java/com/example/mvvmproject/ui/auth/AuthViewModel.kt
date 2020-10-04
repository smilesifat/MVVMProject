package com.example.mvvmproject.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmproject.data.repositories.UserRepository

class AuthViewModel: ViewModel() {

    var email:String?=null
    var password: String?=null
    var authListener:AuthListener?=null

    fun onLoginButtonClick(view: View){
        if(email.isNullOrEmpty()||password.isNullOrEmpty()){
            authListener?.onFailure("Invalid email or Password")
            return
        }
        val loginResponse=UserRepository().userLogin(email!!,password!!)
        authListener?.onSuccess(loginResponse)
    }
}