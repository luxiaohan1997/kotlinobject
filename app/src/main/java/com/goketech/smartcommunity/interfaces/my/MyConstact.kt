package com.goketech.smartcommunity.interfaces.my

import com.goketech.smartcommunity.interfaces.IBaseView
import com.goketech.smartcommunity.interfaces.IPresenter

class MyConstact{
    interface View: IBaseView {
//        fun getIndexReturn(result: IndexBean)
    }

    interface Presenter:
        IPresenter<View> {
        fun getIndex();
    }
}
