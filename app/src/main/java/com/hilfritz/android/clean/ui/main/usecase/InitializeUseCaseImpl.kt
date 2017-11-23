package com.hilfritz.android.clean.ui.main.usecase

import io.reactivex.Scheduler

/**
 * Created by Hilfritz Camallere on 21/11/17.
 *
 */
class InitializeUseCaseImpl(
    var bgThread: Scheduler,
    var mainThread: Scheduler)
    : InitializeUseCase {
    lateinit var view: InitializeUseCase.View

    override fun init(view: InitializeUseCase.View) {
        this.view = view

    }


    override fun run() {
        view.resetViews()
    }

    override fun destroy() {

    }
}