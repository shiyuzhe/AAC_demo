package com.syz.aac_demo.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.syz.aac_demo.data.local.entity.User
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 *   @ClassName: UserDao
 *   @Date: 2019/4/12 3:47 PM
 *   @Author: syz
 *   @Description:
 */
@Dao
interface UserDao {

    /**
     * Insert a userDao in the database. If the userDao already exists, replace it.
     * because of OnConflictStrategy.REPLACE:replace old data and continue transaction.

     * @param user the User to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User) :Completable

    /**
     * Delete all users.
     */
    @Query("DELETE FROM users")
    fun deleteUsers()


    /**
     * Delete all users.
     */
    @Query("DELETE FROM users where u_id = :id")
    fun deleteUser(id: String)


    /**
     * Get a user by id.
     * @return the user from the table with a specific id.
     */
    @Query("SELECT * FROM Users WHERE u_id = :id")
    fun getUserById(id: String): Flowable<User>



}