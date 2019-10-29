package com.goketech.smartcommunity.presenter.login

import com.goketech.smartcommunity.base.BasePresenter
import com.goketech.smartcommunity.commonents.CommonSubscriber
import com.goketech.smartcommunity.commonents.RxUtils
import com.goketech.smartcommunity.interfaces.login.LoginConstact
import com.goketech.smartcommunity.model.HttpManager
import com.goketech.smartcommunity.model.bean.CodeBean

class CodePresenter:BasePresenter<LoginConstact.VerifyView>(),LoginConstact.VerifyPresenter {

    override fun getCode(phone:String) {
        addSubscribe(
            HttpManager.getMyApi().getSmsCode(phone)
                .compose(RxUtils.rxScheduler<CodeBean>())
                .subscribeWith(object: CommonSubscriber<CodeBean>(mView!!){
                    override fun onNext(t: CodeBean?) {
                        mView!!.getCodeReturn(t!!)
                    }

                }))
    }
}