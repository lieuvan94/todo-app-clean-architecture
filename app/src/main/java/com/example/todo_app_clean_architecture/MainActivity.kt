package com.example.todo_app_clean_architecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.domain.usecase.CreateTaskUseCase
import com.example.domain.usecase.GetTaskUseCase

class MainActivity : AppCompatActivity() {

    lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val task = taskViewModel.getTask()

    }
}
