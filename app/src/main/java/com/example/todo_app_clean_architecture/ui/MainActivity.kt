package com.example.todo_app_clean_architecture.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo_app_clean_architecture.R
import com.example.todo_app_clean_architecture.TaskApplication
import com.example.todo_app_clean_architecture.databinding.ActivityMainBinding
import com.example.todo_app_clean_architecture.model.TaskItem
import com.example.todo_app_clean_architecture.viewmodel.TaskViewModel
import com.example.todo_app_clean_architecture.viewmodel.TaskViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModelFactory: TaskViewModelFactory
    private lateinit var  taskViewModel: TaskViewModel
    private lateinit var taskAdapter: TaskAdapter

    private lateinit var  dataBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataBinding = DataBindingUtil.setContentView(this,(R.layout.activity_main))

        viewModelFactory = TaskApplication.getAppContainer().taskViewModelFactory
        taskViewModel = ViewModelProvider(this@MainActivity,viewModelFactory).get(TaskViewModel::class.java)
        taskAdapter = TaskAdapter()
        observeTasks()
        initListener()

    }

    private fun initListener() {
        dataBinding.createTaskButton.setOnClickListener {
            val title = dataBinding.createNewTaskEditText.text.toString()
            taskViewModel.createTask(title)
        }
    }

    private fun observeTasks() {

        taskViewModel.getTask()
        taskViewModel.tasks.observe(this@MainActivity, Observer { tasks ->
            displayTasks(tasks)
        })

        taskViewModel.addedTask.observe(this@MainActivity, Observer { addedTask ->
            displayAddedTask(addedTask)
        })
    }

    private fun displayAddedTask(addedTask: TaskItem) {
        taskAdapter.setList(addedTask)
    }

    private fun displayTasks(tasks: List<TaskItem>) {
        dataBinding.listTask.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = taskAdapter

            taskAdapter.onClickItem = {
            }
        }
    }
}

fun Context.toast(messsage: String) {
    Toast.makeText(
        this,
        messsage,
        Toast.LENGTH_LONG
    ).show()
}



