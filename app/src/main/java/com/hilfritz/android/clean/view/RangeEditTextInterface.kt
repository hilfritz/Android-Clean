package com.hilfritz.android.clean.view

import android.content.res.TypedArray

/**
 * Created by Hilfritz Camallere on 24/11/17.
 *
 */
interface RangeEditTextInterface {

    fun hasInputTypeAttribute(typedArray: TypedArray):kotlin.Boolean
    /**
     * -1 if no value
     * 0 - if character
     * 1 - if integer
     */
    fun getInputTypeAttribute(typedArray: TypedArray):kotlin.Int

    fun getMinInteger(typedArray: TypedArray):kotlin.Int
    fun getMaxInteger(typedArray: TypedArray):kotlin.Int

}