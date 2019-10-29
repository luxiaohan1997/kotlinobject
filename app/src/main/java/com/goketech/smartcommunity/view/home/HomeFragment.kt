package com.goketech.smartcommunity.view.login.home

import android.view.View
import com.goketech.smartcommunity.R
import com.goketech.smartcommunity.base.BaseFragment
import com.goketech.smartcommunity.interfaces.home.HomeConstact
import com.goketech.smartcommunity.model.bean.IndexBean
import com.goketech.smartcommunity.presenter.home.HomePresenter

class HomeFragment: BaseFragment<HomeConstact.View,HomeConstact.Presenter>(),HomeConstact.View{

    override val layout: Int
        get() = R.layout.fragment_home //To change initializer of created properties use File | Settings | File Templates.

    override fun initView(view: View) {
    }

    override fun initData() {
    }

    override fun initPresenter(): HomeConstact.Presenter {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return  HomePresenter()
    }

    override fun getIndexReturn(result: IndexBean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(err: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
