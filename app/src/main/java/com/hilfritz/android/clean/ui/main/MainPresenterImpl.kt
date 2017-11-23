package com.hilfritz.android.clean.ui.main

import com.hilfritz.android.clean.ui.main.usecase.InitializeUseCase
import com.hilfritz.android.clean.ui.main.usecase.InitializeUseCaseImpl
import com.hilfritz.android.clean.ui.main.usecase.LoginUseCase
import com.hilfritz.android.clean.ui.main.usecase.LoginUseCaseImpl
import com.hilfritz.android.clean.ui.router.Router
import io.reactivex.Scheduler

/**
 * Created by Hilfritz Camallere on 21/11/17.
 *
 */
class MainPresenterImpl: MainPresenter {
    lateinit var view: MainView
    lateinit var bgThread: Scheduler
    lateinit var mainThread: Scheduler

    lateinit var initializeUseCase:InitializeUseCase
    lateinit var loginUseCase:LoginUseCase

    override fun init(view: MainView, bgThread: Scheduler, mainThread: Scheduler) {
        this.view = view
        this.bgThread = bgThread
        this.mainThread = mainThread


        //INIT THE USECASES HERE
        initializeUseCase = InitializeUseCaseImpl(bgThread, mainThread)
        initializeUseCase.init(view)

        loginUseCase = LoginUseCaseImpl(bgThread, mainThread, view)
        loginUseCase.init()
    }

    override fun onLoginClickEvent(username: String, pw: String) {
        loginUseCase.run(username, pw)
    }

    override fun populate() {
        initializeUseCase.init(view)
        initializeUseCase.run()
    }

    override fun destroyEvent() {

    }

    override fun onStartEvent() {

    }

    override fun onStopEvent() {

    }

    override fun onResumeEvent() {

    }

    override fun onPauseEvent() {

    }
}