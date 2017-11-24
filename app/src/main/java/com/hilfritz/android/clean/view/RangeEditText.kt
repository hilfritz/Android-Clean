package com.hilfritz.android.clean.view

import android.annotation.TargetApi
import android.content.Context
import android.content.res.TypedArray
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.widget.EditText
import com.hilfritz.android.clean.BuildConfig
import com.hilfritz.android.clean.R


/**
 * Created by Hilfritz Camallere on 24/11/17.
 * see: https://stackoverflow.com/questions/3391272/how-to-use-separate-thread-to-perform-http-requests
 * see: https://stackoverflow.com/questions/6369287/accessing-ui-thread-handler-from-a-service
 */
class RangeEditText : EditText, RangeEditTextInterface {



    val TAG = "RangeEditText"


    enum class InputTypeAttribute
    constructor(val intVal:Int){
        NO_VALUE(-1) ,
        INTEGER (0),
        CHARACTER(1)

    }

    @JvmOverloads
    constructor(
            context: Context,
            attrs: AttributeSet? = null,
            defStyleAttr: Int = 0)
            : super(context, attrs, defStyleAttr){
        init(context, attrs)

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
            context: Context,
            attrs: AttributeSet?,
            defStyleAttr: Int,
            defStyleRes: Int)
            : super(context, attrs, defStyleAttr, defStyleRes){
        init(context, attrs)
    }

    fun init(
            context: Context,
             attrs: AttributeSet?){
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it,
                    R.styleable.range_edit_text_style, 0, 0)

            //CHECK IF ATTRIBUT range_edit_text_style IS SET IN XML
            if (hasInputTypeAttribute(typedArray)) {
                var enum = getInputTypeAttribute(typedArray)

                if (enum!=InputTypeAttribute.NO_VALUE.intVal){

                }else if (enum!=InputTypeAttribute.INTEGER.intVal){
                    val retrievedMaxInteger = getMaxInteger(typedArray)
                    val retrievedMinInteger = getMinInteger(typedArray)
                    var validMaxIntValue = InputTypeAttribute.NO_VALUE.intVal!=retrievedMaxInteger
                    var validMinIntValue = InputTypeAttribute.NO_VALUE.intVal!=retrievedMinInteger

                    var minInt = 0
                    var maxInt = 0

                    if (!validMaxIntValue){
                        maxInt = retrievedMaxInteger
                    }
                    if (!validMinIntValue){
                        minInt = retrievedMinInteger
                    }
                    var isMaxGreaterThanMin = maxInt > minInt
                    if (isMaxGreaterThanMin){

                    }
                }
            }
        }
    }

    fun log(string: String){
        if (BuildConfig.DEBUG) {
            Log.d(TAG, string)
        }
    }


    override fun hasInputTypeAttribute(typedArray: TypedArray): Boolean {
        return typedArray.hasValue(R.styleable.range_edit_text_style_inputType)
    }

    override fun getInputTypeAttribute(typedArray: TypedArray): Int {
        return typedArray.getInt(R.styleable.range_edit_text_style_inputType, InputTypeAttribute.NO_VALUE.intVal)
    }

    override fun getMinInteger(typedArray: TypedArray): Int {
        return typedArray.getInt(R.styleable.range_edit_text_style_maxInteger, InputTypeAttribute.NO_VALUE.intVal)
    }

    override fun getMaxInteger(typedArray: TypedArray): Int {
        return typedArray.getInt(R.styleable.range_edit_text_style_minInteger, InputTypeAttribute.NO_VALUE.intVal)
    }

}
