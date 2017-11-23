package com.hilfritz.android.clean.ui.main

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.hilfritz.android.clean.R
import com.hilfritz.android.clean.base.BaseActivity
import com.hilfritz.android.clean.ui.router.Router
import com.hilfritz.android.clean.ui.router.RouterImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainView {


    var presenter = MainPresenterImpl()
    var router: Router = RouterImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //INITIALIZE THE VIEWS
        presenter.init(this,  Schedulers.io(), AndroidSchedulers.mainThread())
        presenter.populate()
    }

    override fun displaySuccessLogin(str:String) {
        Toast.makeText(this,str, Toast.LENGTH_SHORT).show()
    }

    override fun displayFailLogin(str:String) {
        Toast.makeText(this,str, Toast.LENGTH_LONG).show()
    }

    override fun resetViews() {
        username.setText("")
        password.setText("")
    }

    override fun addLoginClickListener() {
        button.setOnClickListener {
            presenter.onLoginClickEvent(username.text.toString(), password.text.toString())
        }
    }

    override fun getActivityContext(): Context {
        return this
    }
    override fun openListingPage() {
        router.openListing(this)
    }

}
