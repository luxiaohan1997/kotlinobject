package com.goketech.smartcommunity.view.login.activitys

import android.text.TextUtils
import android.view.View
import com.goketech.smartcommunity.R
import com.goketech.smartcommunity.base.BaseActivity
import com.goketech.smartcommunity.interfaces.login.LoginConstact
import com.goketech.smartcommunity.presenter.login.CodePresenter
import com.goketech.smartcommunity.utils.MyUtils
import kotlinx.android.synthetic.main.activity_code.*


class CodeActivity: BaseActivity<LoginConstact.VerifyView, LoginConstact.VerifyPresenter>(), View.OnClickListener {

//    lateinit var phone:String

    var code=""
    var mode="2"
    var phone=""
    var sign=""

    override fun initView() {
        txt_resetVerify.setOnClickListener(this)
        txt_verifyLogin.setOnClickListener(this)
        phone=intent.getStringExtra("phone")
        sign=intent.getStringExtra("sign")
    }

    override fun initData() {
        phone = intent.getStringExtra("phone")
        if(!TextUtils.isEmpty(phone)){
            var str = getString(R.string.tips_phone_sendverify).replace("$",phone)
            txt_tips_phone.setText(str)
        }
    }

    override fun initPresenter(): LoginConstact.VerifyPresenter {
        return CodePresenter()
    }

    override val layout: Int
        get() = R.layout.activity_code


    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.txt_verifyLogin ->
                sendLogin()
            R.id.txt_resetVerify->
                getVerify()
        }
    }

    fun getVerify(){
        if(!TextUtils.isEmpty(phone) && MyUtils.checkMoblie(phone)){
//            presenter!!.getCode(phone)
        }else{
            showTipsShort(getString(R.string.tips_phone))
        }
    }

    fun sendLogin(){
        code = verify_code.phoneCode
    }

}