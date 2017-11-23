package com.hilfritz.android.clean.base

import io.reactivex.Scheduler

/**
 * Created by Hilfritz Camallere on 21/11/17.
 *
 */
interface BasePresenter<BaseView> {
    /**
     * must be called only once
     *  - onCreateView()/onCreate()
     */
    fun init(view: BaseView, bgThread: Scheduler, mainThread: Scheduler)

    /**
     * also called only once
     */
    fun populate()

    /**
     * LIFECYCLE EVENTS
     */

    fun destroyEvent()
    fun onStartEvent()
    fun onStopEvent()
    fun onResumeEvent()
    fun onPauseEvent()

}