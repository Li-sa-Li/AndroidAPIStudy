package com.example.android.observability.imitate.persistance

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.util.*

@Entity(tableName = "users")
data class ImitateUser(
        @PrimaryKey
        @ColumnInfo(name="userId")
        val userId:String=UUID.randomUUID().toString(),
        @ColumnInfo(name="userName")
        val  name:String) {
}