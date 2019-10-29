package com.goketech.smartcommunity.view.notifications

import android.view.View
import com.goketech.smartcommunity.R
import com.goketech.smartcommunity.base.BaseFragment
import com.goketech.smartcommunity.interfaces.notifications.NotificationsConstact
import com.goketech.smartcommunity.presenter.notifications.NotificationsPresenter

class NotificationsFragment: BaseFragment<NotificationsConstact.View, NotificationsConstact.Presenter>(),
    NotificationsConstact.View{
    override val layout: Int
        get() = R.layout.fragment_notifcations //To change initializer of created properties use File | Settings | File Templates.

    override fun initView(view: View) {
    }

    override fun initData() {
    }

    override fun initPresenter(): NotificationsConstact.Presenter {
        return NotificationsPresenter()
    }

    override fun onError(err: String) {
    }

}