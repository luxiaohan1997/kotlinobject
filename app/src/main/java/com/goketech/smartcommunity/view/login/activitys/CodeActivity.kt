package com.goketech.smartcommunity.view.login.activitys

import android.content.Context
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.goketech.smartcommunity.MainActivity
import com.goketech.smartcommunity.R
import com.goketech.smartcommunity.base.BaseActivity
import com.goketech.smartcommunity.constants.Constant
import com.goketech.smartcommunity.interfaces.login.LoginConstact
import com.goketech.smartcommunity.model.bean.CodeBean
import com.goketech.smartcommunity.model.bean.LoginBean
import com.goketech.smartcommunity.presenter.login.LoginPresenter

import com.goketech.smartcommunity.utils.MyUtils
import kotlinx.android.synthetic.main.activity_code.*


class CodeActivity: BaseActivity<LoginConstact.View,LoginConstact.Presenter>(),LoginConstact.View, View.OnClickListener {


//    lateinit var phone:String

    var code=""
    var mode="2"
    var phone=""
    var sign=""

    override fun initView() {
        txt_resetVerify.setOnClickListener(this)
        txt_verifyLogin.setOnClickListener(this)
    }

    override fun initData() {
        phone = intent.getStringExtra("phone")
        if(!TextUtils.isEmpty(phone)){
            var str = getString(R.string.tips_phone_sendverify).replace("$",phone)
            txt_tips_phone.setText(str)
        }
    }

//    override fun initPresenter(): LoginConstact. {
////        return CodePresenter()
////    }
    override fun initPresenter(): LoginConstact.Presenter {
        return LoginPresenter()
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

    fun sendLogin(){//登录
        code = verify_code.phoneCode
        val map = HashMap<String, String>()
        map.put("phone",phone)//手机号
        map.put("mode","2")
        map.put("code",code)//验证码
        val sign1 = MyUtils.getSign(map)//获取签名
        map.put("sign",sign1!!)
        presenter!!.login(map)
    }
    override fun loginReturn(result: LoginBean) {
        if (result.status==Constant.RESULT_CODE_SUCCESS){
            Constant.TOKEN=result.data.token
            val intent = intent
            intent.setClass(context,MainActivity::class.java)
            startActivity(intent)
        }else if (result.status==Constant.RESULT_CODE_NOSETPW){
            Toast.makeText(context,"失败",Toast.LENGTH_LONG).show()
        }
    }

    override fun getCodeReturn(result: CodeBean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}