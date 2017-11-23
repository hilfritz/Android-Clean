package com.hilfritz.android.clean.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.airbnb.lottie.LottieAnimationView
import com.hilfritz.android.clean.R
import com.hilfritz.android.clean.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_list.*
import java.io.IOException


/**
 * A placeholder fragment containing a simple view.
 */
class ListActivityFragment : BaseFragment() {
    //@BindView(R.id.text)
    //lateinit var text: EditText

    val TAG = "ListActivityFragment"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text!!.setText("halu there")
        vertival_linearlayout.removeAllViews()

        for (allAssetsFile in getAllJsonLottieAssetsFiles("")) {
            //Toast.makeText(activity, ">>>"+ allAssetsFile, Toast.LENGTH_SHORT).show()
            Log.d(TAG, ">>>"+ allAssetsFile)
        }

        val allJsonLottieAssetsFiles = getAllJsonLottieAssetsFiles("")
        var possible2PairCount = Math.floor((allJsonLottieAssetsFiles.size / 2).toDouble())
        //possible2PairCount.forEach { x:kotlin.Int -> }


        val layoutInflater = LayoutInflater.from(activity)
        var counter = 0
        for (x in 0 until possible2PairCount.toInt()) {
            val newRow = layoutInflater.inflate(R.layout.animation_row, null)

            var leftAnimation = newRow.findViewById<LottieAnimationView>(R.id.animation_view)
            var rightAnimation = newRow.findViewById<LottieAnimationView>(R.id.animation_view2)

            if (counter!=0)
                counter++

            var leftAnimationFile = allJsonLottieAssetsFiles[counter]
            var rightAnimationFile:String? = null


            var even = (counter%2==0)
            counter++
            if (even) {
                Log.d(TAG, "even")
                //ODD
                rightAnimationFile = allJsonLottieAssetsFiles[counter]
            }else{
                Log.d(TAG, "odd")
            }
            leftAnimation.imageAssetsFolder = "images/";
            leftAnimation.setAnimation(leftAnimationFile)
            leftAnimation.loop(true)
            leftAnimation.playAnimation()

            rightAnimationFile?.let {
                rightAnimation.imageAssetsFolder = "images/";
                rightAnimation.setAnimation(rightAnimationFile)
                rightAnimation.loop(true)
                rightAnimation.playAnimation()
            }
            (vertival_linearlayout as LinearLayout).addView(newRow)

            Log.d(TAG, "left:"+leftAnimationFile+" right:"+rightAnimationFile)
        }

    }

    private fun listAssetFiles(path: String): Boolean {

        var list: Array<String>
        try {
            list = activity.assets.list(path)
            if (list.size > 0) {
                // This is a folder
                for (file in list) {
                    /*
                    if (!listAssetFiles(path + "/" + file))
                        return false
                    else {
                        // This is a file
                        // TODO: add file name to an array list
                    }*/

                }
            }
        } catch (e: IOException) {
            return false
        }
        return true
    }

    private fun getAllJsonLottieAssetsFiles(path: String): ArrayList<String> {

        var list: Array<String>
        var list2: ArrayList<String> = ArrayList<String>()
        try {
            list = activity.assets.list(path)
            if (list.size > 0) {
                // This is a folder
                for (filename in list) {
                    if (filename.contains(".json")) {
                        list2.add(path + "" + filename)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return list2
        }
        return list2
    }


}
