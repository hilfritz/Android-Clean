package com.hilfritz.android.clean.ui.list

import android.os.Bundle
import android.support.design.widget.Snackbar
import com.hilfritz.android.clean.R
import com.hilfritz.android.clean.base.BaseActivity
import kotlinx.android.synthetic.main.activity_list.*

class ListingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
