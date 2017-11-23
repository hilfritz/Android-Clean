package com.hilfritz.android.clean.ui.main.usecase

import com.hilfritz.android.clean.base.BaseUseCase

/**
 * Created by Hilfritz Camallere on 21/11/17.
 *
 */
interface InitializeUseCase:BaseUseCase {
    fun init(view:View)

    interface Presenter{

    }
    interface View{
        fun resetViews()
    }

}