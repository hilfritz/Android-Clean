package com.hilfritz.android.clean.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hilfritz.android.clean.R
import com.hilfritz.android.clean.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_list.*


/**
 * A placeholder fragment containing a simple view.
 */
class ListActivityFragment : BaseFragment() {
    //@BindView(R.id.text)
    //lateinit var text: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text!!.setText("halu there")
    }


}
