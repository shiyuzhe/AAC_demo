package com.syz.aac_demo.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.syz.aac_demo.data.local.entity.User
import com.syz.aac_demo.data.repo.UserRepository
import com.syz.aac_demo.data.repo.UserRepository.Companion.u_id
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *   @ClassName: UserViewModel
 *   @Date: 2019/4/12 4:04 PM
 *   @Author: syz
 *   @Description:
 */
class UserViewModel:ViewModel() {
    private val userRepository by lazy {
        UserRepository()
    }

    var data : MutableLiveData<User>?=null
    get() {
        if(field == null){
            field =  MutableLiveData()
            getUser()
        }
        return field
    }

    private fun getUser(){
        val subscribe = userRepository.getUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { data?.value = it }
    }

    fun updateUserName(name:String){
        val subscribe = userRepository.insertUser(User(u_id, name)).subscribeOn(Schedulers.io()).subscribe {
            Log.e("syz", "updateSuccess")
        }
    }
}