package com.hilfritz.android.clean.ui.main

import com.hilfritz.android.clean.base.BasePresenter
import com.hilfritz.android.clean.ui.main.usecase.InitializeUseCase
import com.hilfritz.android.clean.ui.main.usecase.LoginUseCase

/**
 * Created by Hilfritz Camallere on 21/11/17.
 *
 */
interface MainPresenter:BasePresenter<MainView>, InitializeUseCase.Presenter, LoginUseCase.Presenter {

}