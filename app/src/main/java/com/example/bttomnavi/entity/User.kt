package com.example.bttomnavi.entity

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.bttomnavi.BR
//data class User(val firstName: String, val lastName: String)

class User : BaseObservable() {

    @get:Bindable
    var firstName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.firstName)
        }

    @get:Bindable
    var lastName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.lastName)
        }
}