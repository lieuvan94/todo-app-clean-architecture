package com.example.todo_app_clean_architecture.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_app_clean_architecture.BR
import com.example.todo_app_clean_architecture.R
import com.example.todo_app_clean_architecture.model.TaskItem
import kotlinx.android.synthetic.main.item_task.view.*

/**
 * Created by Nguyen Văn Lieu on 3/25/2020
 */
class TaskAdapter : RecyclerView.Adapter<TaskAdapter.BindingHolder>(){

    private val dataList : ArrayList<TaskItem> = ArrayList()

    var onClickItem:(taskItem:TaskItem) -> Unit = {_ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val layoutId = R.layout.item_task
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false
            )
        return BindingHolder(binding)
    }

    override fun getItemCount()= dataList.size

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val data = dataList[position]
        holder.binding.setVariable(BR.data,data)
        holder.binding.root.textPosition.text = dataList[position].id.toString()
        holder.binding.executePendingBindings()
    }

    fun setList(addedTask: TaskItem) {
        dataList.add(addedTask)
        notifyItemInserted(itemCount - 1)
    }

    class BindingHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}
