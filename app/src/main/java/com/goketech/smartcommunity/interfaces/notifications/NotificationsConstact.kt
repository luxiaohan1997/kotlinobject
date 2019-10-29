package com.goketech.smartcommunity.interfaces.notifications

import com.goketech.smartcommunity.interfaces.IBaseView
import com.goketech.smartcommunity.interfaces.IPresenter

interface NotificationsConstact{
    interface View: IBaseView {
//        fun getIndexReturn(result: IndexBean)
    }
    interface Presenter:
        IPresenter<View> {
        fun getIndex();
    }
}
