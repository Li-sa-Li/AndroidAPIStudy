package com.example.android.observability.imitate.persistance

import android.content.Context
import androidx.room.*

@Database(entities = [ImitateUser::class], version = 1)
abstract  class ImitateUserDataBase : RoomDatabase() {

    public abstract fun initImitateUserDao():ImitateUserDao

    companion object{
        private var INSTANCE:ImitateUserDataBase?=null

        fun getInstance(context: Context):ImitateUserDataBase=
           INSTANCE?:synchronized(this){
                INSTANCE?: buildDataBase(context).also { INSTANCE=it }
            }

        private fun buildDataBase(context: Context)=
            Room.databaseBuilder(context,ImitateUserDataBase::class.java,"demo.db").build()

    }
}