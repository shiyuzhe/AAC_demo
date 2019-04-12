package com.syz.aac_demo.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *   @ClassName: User
 *   @Date: 2019/4/12 3:42 PM
 *   @Author: syz
 *   @Description:
 */
@Entity(tableName = "users")
data class  User (@PrimaryKey
    @ColumnInfo(name = "u_id") val id:String,
                  @ColumnInfo(name = "u_name") val name:String)