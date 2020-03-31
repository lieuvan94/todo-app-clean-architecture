package com.example.todo_app_clean_architecture.utils.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Nguyen Văn Lieu on 3/31/2020
 */
class SchedulerProviderImpl : SchedulerProvider {

    override fun io(): Scheduler = Schedulers.io()

    override fun ui(): Scheduler = AndroidSchedulers.mainThread()

    override fun newThread(): Scheduler = Schedulers.newThread()

    override fun computation(): Scheduler = Schedulers.computation()
}