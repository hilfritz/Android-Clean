package com.hilfritz.android.clean.ui.router

import android.app.Activity
import android.content.Intent
import com.hilfritz.android.clean.ui.list.ListingActivity

/**
 * Created by Hilfritz Camallere on 22/11/17.
 *
 */
class RouterImpl: Router {
    override fun openListing(context: Activity) {
        context.runOnUiThread{
            context.startActivity(Intent(context, ListingActivity::class.java))
        }
    }

}