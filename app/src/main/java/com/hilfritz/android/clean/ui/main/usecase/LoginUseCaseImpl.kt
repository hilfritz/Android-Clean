package com.hilfritz.android.clean.ui.main.usecase

import com.hilfritz.android.clean.ui.main.MainView
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.observers.DisposableObserver
import java.util.regex.Pattern

/**
 * Created by Hilfritz Camallere on 21/11/17.
 *
 */
class LoginUseCaseImpl(
        var bgThread: Scheduler,
        var mainThread: Scheduler,
        var view: MainView
): LoginUseCase {

    enum class CREDENTIAL_VERIFICATION_RESULTS {
        INPUT_CORRECT {
            override fun toString(): String {
                return "Successful!"
            }
        },
        PASSWORD_LENGTH_INCORRECT{
            override fun toString(): String {
                return "Password must be more than 5 characters."
            }
        },
        EMAIL_FORMAT_INCORRECT{
            override fun toString(): String {
                return "Email needed."
            }
        },
        EMPTY_PASSWORD{
            override fun toString(): String {
                return "Password needed."
            }
        },
        EMPTY_USERNAME{
            override fun toString(): String {
                return "Email needed."
            }
        }
    }

    var username: String = ""
    var password: String = ""

    val correctUsername = "johndoe@email.com"
    val correctPassword = "password"

    /**
     * method is used for checking valid email id format.
     *
     * @param email
     * @return boolean true for valid false for invalid
     */
    override fun isEmailValidFormat(email: String): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    override fun init() {
        username = ""
        password = ""
        view.addLoginClickListener()
    }

    override fun run(username: String, pw: String) {
        this.password = pw
        this.username = username
        run()
    }

    override fun run() {

        Observable.just(isLoginOkay())
                .observeOn(mainThread)
                .subscribeOn(bgThread)
                .subscribe(object: DisposableObserver<CREDENTIAL_VERIFICATION_RESULTS>() {
                    override fun onComplete() {
                    }

                    override fun onNext(t: CREDENTIAL_VERIFICATION_RESULTS) {


                        when (t) {
                            CREDENTIAL_VERIFICATION_RESULTS.INPUT_CORRECT ->
                            {

                                view.displaySuccessLogin(t.toString())
                                view.resetViews()
                                view.openListingPage()
                            }
                            CREDENTIAL_VERIFICATION_RESULTS.EMAIL_FORMAT_INCORRECT -> view.displayFailLogin(t.toString())
                            CREDENTIAL_VERIFICATION_RESULTS.PASSWORD_LENGTH_INCORRECT -> view.displayFailLogin(t.toString())
                            CREDENTIAL_VERIFICATION_RESULTS.EMPTY_PASSWORD -> view.displayFailLogin(t.toString())
                            CREDENTIAL_VERIFICATION_RESULTS.EMPTY_USERNAME -> view.displayFailLogin(t.toString())
                        }
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                })

    }

    override fun destroy() {

    }



    override fun isLoginOkay(): LoginUseCaseImpl.CREDENTIAL_VERIFICATION_RESULTS {

        var retVal = CREDENTIAL_VERIFICATION_RESULTS.INPUT_CORRECT

        var inputLengthsOk =  true


        if (password.length==0) {
            inputLengthsOk = false
            retVal = CREDENTIAL_VERIFICATION_RESULTS.EMPTY_PASSWORD
        }

        if (username.length==0) {
            inputLengthsOk = false
            retVal = CREDENTIAL_VERIFICATION_RESULTS.EMPTY_USERNAME
        }

        if (inputLengthsOk) {
            var emailValidation = isEmailValidFormat(username)
            var passwordValidation = isPasswordLengthValidFormat(password)

            if (!passwordValidation) {
                retVal = CREDENTIAL_VERIFICATION_RESULTS.PASSWORD_LENGTH_INCORRECT
            }

            if (!emailValidation) {
                retVal = CREDENTIAL_VERIFICATION_RESULTS.EMAIL_FORMAT_INCORRECT
            }
        }
        return retVal
    }
    override fun isPasswordLengthValidFormat(ow: String): Boolean {
        ow?.let {
            if (ow.length>5)
                return true
        }
        return false
    }
}