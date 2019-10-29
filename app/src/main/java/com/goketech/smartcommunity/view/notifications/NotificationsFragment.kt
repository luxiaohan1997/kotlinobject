package com.goketech.smartcommunity.view.notifications

import android.view.View
import com.goketech.smartcommunity.base.BaseFragment
import com.goketech.smartcommunity.interfaces.notifications.NotificationsConstact

class NotificationsFragment: BaseFragment<NotificationsConstact.View, NotificationsConstact.Presenter>(),
    NotificationsConstact.View{
    override val layout: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun initView(view: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initPresenter(): NotificationsConstact.Presenter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(err: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}