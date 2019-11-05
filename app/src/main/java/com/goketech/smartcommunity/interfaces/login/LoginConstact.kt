package com.goketech.smartcommunity.interfaces.login

import com.goketech.smartcommunity.interfaces.IBaseView
import com.goketech.smartcommunity.interfaces.IPresenter
import com.goketech.smartcommunity.model.bean.CodeBean
import com.goketech.smartcommunity.model.bean.LoginBean
import okhttp3.RequestBody

interface LoginConstact {

    interface View:IBaseView{
        fun loginReturn(result:LoginBean)
        fun codeReturn(result: CodeBean)
        fun passWordReturn(result: CodeBean)
    }

    interface Presenter:IPresenter<View>{
        fun login(param:Map<String,String>)
        fun cord(param: Map<String, String>)
        fun passWord(param: Map<String, String>)
    }

    interface VerifyView:IBaseView{
        fun getCodeReturn(result:CodeBean)
        fun getPhoneReturn(result: LoginBean)
    }

    interface VerifyPresenter:IPresenter<VerifyView>{
        fun getCode(phone:Map<String,String>)
        fun getPhone(param: Map<String, String>)
    }
}