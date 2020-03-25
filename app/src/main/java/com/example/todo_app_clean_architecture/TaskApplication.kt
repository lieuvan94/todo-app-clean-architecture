package com.example.todo_app_clean_architecture

import android.app.Application

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
class TaskApplication : Application(){
    companion object{
        private lateinit var appContainer: AppContainer

        fun getAppContainer():AppContainer{
            return appContainer
        }
    }

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(this)
    }
}