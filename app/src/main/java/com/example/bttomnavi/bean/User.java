package com.example.bttomnavi.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.example.bttomnavi.BR;

/**
 * 创建数据双向绑定 Bean 在结构上其更贴近于java,比较倾向于这种结构
 * */

public class User extends BaseObservable {

    private String phone;
    private String vercode;

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String name) {
        this.phone = name;
        notifyPropertyChanged(BR.phone);

    }
    @Bindable
    public String getVercode() {
        return vercode;
    }

    public void setVercode(String vercode) {
        this.vercode = vercode;
        //数据改变时，刷新数据
        notifyPropertyChanged(BR.vercode);
    }
}