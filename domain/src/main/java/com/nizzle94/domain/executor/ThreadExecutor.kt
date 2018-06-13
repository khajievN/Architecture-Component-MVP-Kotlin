package com.nizzle94.domain.executor

import io.reactivex.Scheduler

interface ThreadExecutor {
    fun getScheduler(): Scheduler
}
