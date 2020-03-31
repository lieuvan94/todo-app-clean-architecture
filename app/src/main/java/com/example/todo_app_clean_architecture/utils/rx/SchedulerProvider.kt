package com.example.todo_app_clean_architecture.utils.rx

import io.reactivex.Scheduler

/**
 * Created by Nguyen Văn Lieu on 3/31/2020
 */
interface SchedulerProvider {
    fun io() :Scheduler
    fun ui() : Scheduler
    fun newThread(): Scheduler
    fun computation():Scheduler
}