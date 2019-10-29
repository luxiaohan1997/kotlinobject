package com.goketech.smartcommunity.interfaces.event

import com.goketech.smartcommunity.interfaces.IBaseView
import com.goketech.smartcommunity.interfaces.IPresenter
import com.goketech.smartcommunity.model.bean.IndexBean

class EventConstact{
    interface View: IBaseView {
//        fun getIndexReturn(result: IndexBean)
    }

    interface Presenter:
        IPresenter<View> {
        fun getIndex();
    }
}