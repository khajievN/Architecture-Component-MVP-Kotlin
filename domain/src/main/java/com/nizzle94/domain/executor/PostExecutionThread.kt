package com.nizzle94.domain.executor

import io.reactivex.Scheduler

interface PostExecutionThread {
    fun getScheduler(): Scheduler
}
