package com.goketech.smartcommunity.interfaces.login

import com.goketech.smartcommunity.interfaces.IBaseView
import com.goketech.smartcommunity.interfaces.IPresenter
import com.goketech.smartcommunity.model.bean.CodeBean
import com.goketech.smartcommunity.model.bean.LoginBean
import okhttp3.RequestBody

interface LoginConstact {

    interface View:IBaseView{  //login   v
        fun loginReturn(result:LoginBean)
        fun getCodeReturn(result:CodeBean)
    }

    interface Presenter:IPresenter<View>{  //login p
        fun login(param:Map<String,String>);
        fun  getCode(phone:Map<String ,String>)
    }
}