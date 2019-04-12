package com.syz.aac_demo.data.local

import androidx.room.*
import com.syz.aac_demo.App
import com.syz.aac_demo.data.local.dao.UserDao
import com.syz.aac_demo.data.local.entity.User

/**
 *   @ClassName: MyRoomDatabase
 *   @Date: 2019/4/12 3:53 PM
 *   @Author: syz
 *   @Description:
 */

@Database(entities = [User::class], version = 1)
abstract class MyRoomDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {

        @Volatile private var INSTANCE: MyRoomDatabase? = null

        fun getInstance(): MyRoomDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase().also { INSTANCE = it }
            }

        private fun buildDatabase() =
            Room.databaseBuilder(App.getIns(),
                MyRoomDatabase::class.java, "Sample.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}