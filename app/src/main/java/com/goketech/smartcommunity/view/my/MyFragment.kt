package com.goketech.smartcommunity.view.my

import android.view.View
import com.goketech.smartcommunity.R
import com.goketech.smartcommunity.base.BaseFragment
import com.goketech.smartcommunity.interfaces.my.MyConstact
import com.goketech.smartcommunity.presenter.my.MyPresenter

class MyFragment :BaseFragment<MyConstact.View,MyConstact.Presenter>(),MyConstact.View{
    override val layout: Int
        get() = R.layout.fragment_my

    override fun initView(view: View) {
    }

    override fun initData() {
    }

    override fun initPresenter(): MyConstact.Presenter {
        return MyPresenter()
    }

    override fun onError(err: String) {
    }

}