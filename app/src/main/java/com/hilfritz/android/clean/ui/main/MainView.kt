package com.hilfritz.android.clean.ui.main

import com.hilfritz.android.clean.base.BaseView
import com.hilfritz.android.clean.ui.main.usecase.InitializeUseCase
import com.hilfritz.android.clean.ui.main.usecase.LoginUseCase

/**
 * Created by Hilfritz Camallere on 21/11/17.
 *
 */
interface MainView:BaseView, InitializeUseCase.View, LoginUseCase.View {

}