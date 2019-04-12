package com.syz.aac_demo.data.repo

import com.syz.aac_demo.data.local.MyRoomDatabase
import com.syz.aac_demo.data.local.entity.User
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 *   @ClassName: UserRepository
 *   @Date: 2019/4/12 3:58 PM
 *   @Author: syz
 *   @Description:
 */
class UserRepository {
    private val userDao by lazy {
        MyRoomDatabase.getInstance().userDao()
    }

    fun getUser(): Flowable<User> {
        return userDao.getUserById(u_id)
    }

    fun insertUser(user: User):Completable{
        return userDao.insertUser(user)
    }

    companion object {
        const val u_id = "userId"
    }
}