package com.hilfritz.android.clean.ui.main.usecase

import com.hilfritz.android.clean.base.BaseUseCase

/**
 * Created by Hilfritz Camallere on 21/11/17.
 *
 */
interface LoginUseCase:BaseUseCase {

    fun init()
    fun run(username:kotlin.String, pw:kotlin.String)
    fun isLoginOkay(): LoginUseCaseImpl.CREDENTIAL_VERIFICATION_RESULTS

    fun isEmailValidFormat(email: String): Boolean
    fun isPasswordLengthValidFormat(ow: String): Boolean

    interface Presenter{
        fun onLoginClickEvent(username:kotlin.String, pw:kotlin.String)
    }

    interface View{
        fun addLoginClickListener()
        fun displaySuccessLogin(str: String)
        fun displayFailLogin(str:String)
        fun openListingPage()
    }

}