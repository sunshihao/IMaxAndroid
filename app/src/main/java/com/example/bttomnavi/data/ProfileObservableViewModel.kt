/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.bttomnavi.data

import android.widget.Toast
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.bttomnavi.BR
import com.example.bttomnavi.util.ObservableViewModel

/**
 * This class is used as a variable in the XML layout and it's fully observable, meaning that
 * changes to any of the exposed observables automatically refresh the UI. *
 */
class ProfileLiveDataViewModel : ViewModel() {
    private val _phone = MutableLiveData("17615150217")
    private val _vercode = MutableLiveData("123456")
//    private val _likes =  MutableLiveData(0)

    val phone: LiveData<String> = _phone
    val vercode: LiveData<String> = _vercode
//    val likes: LiveData<Int> = _likes

//    val popularity: LiveData<Popularity> = Transformations.map(_likes) {
//        when {
//            it > 9 -> Popularity.STAR
//            it > 4 -> Popularity.POPULAR
//            else -> Popularity.NORMAL
//        }
//    }

    fun onLike() {
//        _likes.value = (_likes.value ?: 0) + 1
    }

//    fun onInputChange(val: String){
////        _vercode.value = val
//    }

    fun onLogin(){
        // 动态内部跳转的问题
//        val intent= Intent(this, MainActivity::class.java)
//        startActivity(Intent(MainActivity2@this,SelectActivity::class.java)
//        startActivity(intent)
    }
}

/**
 * As an alternative to LiveData, you can use Observable Fields and binding properties.
 *
 * `Popularity` is exposed here as a `@Bindable` property so it's necessary to call
 * `notifyPropertyChanged` when any of the dependent properties change (`likes` in this case).
 */
//
enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}

// 这个定义是这个意思啊
//private fun ObservableInt.increment() {
//    set(get() + 1)
//}
