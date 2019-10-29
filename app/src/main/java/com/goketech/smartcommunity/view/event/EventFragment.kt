package com.goketech.smartcommunity.view.event

import android.view.View
import com.goketech.smartcommunity.R
import com.goketech.smartcommunity.base.BaseFragment
import com.goketech.smartcommunity.interfaces.event.EventConstact
import com.goketech.smartcommunity.presenter.event.EventPresenter

class EventFragment :BaseFragment<EventConstact.View,EventConstact.Presenter>(),EventConstact.View{
    override val layout: Int
        get() = R.layout.fragment_event //To change initializer of created properties use File | Settings | File Templates.

    override fun initView(view: View) {
    }

    override fun initData() {
    }

    override fun initPresenter(): EventConstact.Presenter {
        return EventPresenter()
    }

    override fun onError(err: String) {
    }

}