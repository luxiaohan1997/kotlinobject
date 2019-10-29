package com.goketech.smartcommunity.view.login.activitys

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.TextureView
import android.view.View
import android.widget.Toast
import com.goketech.smartcommunity.R
import com.goketech.smartcommunity.base.BaseActivity
import com.goketech.smartcommunity.constants.Constant
import com.goketech.smartcommunity.interfaces.login.LoginConstact
import com.goketech.smartcommunity.model.bean.LoginBean
import com.goketech.smartcommunity.presenter.login.LoginPresenter
import com.goketech.smartcommunity.utils.MyUtils
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.FormBody
import okhttp3.MediaType
import okhttp3.RequestBody

class LoginActivity:BaseActivity<LoginConstact.View,LoginConstact.Presenter>(),LoginConstact.View, View.OnClickListener {


    var mode = "1"
    var phone = ""
    var password = ""
    var code = ""

    override fun initView() {
        txt_loginCode.setOnClickListener(this)
        txt_loginPw.setOnClickListener(this)
        txt_getverify.setOnClickListener(this)
    }

    override fun initData() {

    }

    override fun initPresenter(): LoginConstact.Presenter {
        return LoginPresenter()
    }


    override val layout: Int
        get() = R.layout.activity_login


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.txt_loginCode ->{
                mode = "1"
                layout_verify.visibility = View.VISIBLE
                layout_pw.visibility = View.GONE
                txt_loginCode.isEnabled = false
                txt_loginPw.isEnabled = true
            }
            R.id.txt_loginPw -> {
                mode = "2"
                layout_verify.visibility = View.GONE
                layout_pw.visibility = View.VISIBLE
                txt_loginCode.isEnabled = true
                txt_loginPw.isEnabled = false
            }
            R.id.txt_login -> {
                saveLogin()
            }
            R.id.txt_getverify -> {
                phone = txt_codePhone.text.toString()
                var intent = Intent()
                intent.setClass(context,CodeActivity::class.java)
                intent.putExtra("phone",phone)
                startActivity(intent)
            }

        }
    }

    fun saveLogin(){
        phone = txt_phone.text.toString()
        password = txt_pw.text.toString()
        code = txt_loginCode.text.toString()
        if(mode.equals("1")){
            if(!TextUtils.isEmpty(phone)){
                if(!MyUtils.checkMoblie(phone)){
                    Toast.makeText(this,getString(R.string.tips_phone),Toast.LENGTH_SHORT).show()
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(this,getString(R.string.tips_phone),Toast.LENGTH_SHORT).show()
                    return;
                }
                var param = HashMap<String,String>()
                param.put("mode",mode)
                param.put("phone",phone)
                param.put("password",password)
                sendLoginData(param)
            }else{
                Toast.makeText(this,getString(R.string.tips_phone),Toast.LENGTH_SHORT).show()
            }
        }else if(mode.equals("2")){
            if(!TextUtils.isEmpty(phone)){
                if(!MyUtils.checkMoblie(phone)){
                    Toast.makeText(this,getString(R.string.tips_phone),Toast.LENGTH_SHORT).show()
                    return;
                }
                if(TextUtils.isEmpty(code)){
                    Toast.makeText(this,getString(R.string.tips_phone),Toast.LENGTH_SHORT).show()
                    return;
                }
                var param = HashMap<String,String>()
                param.put("mode",mode)
                param.put("phone",phone)
                param.put("code",code)
                sendLoginData(param)
            }else{
                Toast.makeText(this,getString(R.string.tips_phone),Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun sendLoginData(request:Map<String,String>){
        presenter!!.login(request)
    }

    override fun loginReturn(result: LoginBean) {
        if(result.status == Constant.RESULT_CODE_SUCCESS){
            //跳转界面
        }else if(result.status == Constant.RESULT_CODE_NOSETPW){
            //提示
        }
    }



}