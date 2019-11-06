package com.goketech.smartcommunity.presenter.login

import android.util.Log
import com.goketech.smartcommunity.base.BasePresenter
import com.goketech.smartcommunity.commonents.CommonSubscriber
import com.goketech.smartcommunity.commonents.RxUtils
import com.goketech.smartcommunity.constants.Constant
import com.goketech.smartcommunity.interfaces.login.LoginConstact
import com.goketech.smartcommunity.model.HttpManager
import com.goketech.smartcommunity.model.bean.CodeBean
import com.goketech.smartcommunity.model.bean.IndexBean
import com.goketech.smartcommunity.model.bean.LoginBean
import okhttp3.RequestBody

class LoginPresenter: BasePresenter<LoginConstact.View>(),LoginConstact.Presenter {

    override fun getCode(phone: Map<String, String>) {
        addSubscribe(
            HttpManager.getMyApi().getSmsCode(phone)
                .compose(RxUtils.rxScheduler<CodeBean>())
                .subscribeWith(object: CommonSubscriber<CodeBean>(mView!!){
                    override fun onNext(t: CodeBean?) {
                        mView!!.getCodeReturn(t!!)
                    }

                    override fun onError(t: Throwable) {
                        super.onError(t)
                        Log.i("tag",t.toString());
                    }

                }))
    }

    override fun login(param:Map<String,String>) {

        addSubscribe(
            HttpManager.getMyApi().login(param)
                .compose(RxUtils.rxScheduler<LoginBean>())
                .subscribeWith(object: CommonSubscriber<LoginBean>(mView!!){
                    override fun onNext(t: LoginBean?) {
                        mView!!.loginReturn(t!!)
                    }

                }))
    }
}