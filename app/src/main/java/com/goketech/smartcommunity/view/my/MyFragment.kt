package com.goketech.smartcommunity.view.my

import android.view.View
import com.goketech.smartcommunity.base.BaseFragment
import com.goketech.smartcommunity.interfaces.my.MyConstact

class MyFragment :BaseFragment<MyConstact.View,MyConstact.Presenter>(),MyConstact.View{
    override val layout: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun initView(view: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initPresenter(): MyConstact.Presenter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(err: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}