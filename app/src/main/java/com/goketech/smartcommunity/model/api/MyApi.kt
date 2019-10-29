package com.goketech.smartcommunity.model.api

import com.goketech.smartcommunity.model.bean.CodeBean
import com.goketech.smartcommunity.model.bean.IndexBean
import com.goketech.smartcommunity.model.bean.LoginBean
import io.reactivex.Flowable
import okhttp3.RequestBody
import retrofit2.http.*

interface MyApi {

    @GET("index")
    fun getIndexData(): Flowable<IndexBean>

    @POST("login")
    @FormUrlEncoded
    fun login(@FieldMap param:Map<String,String>):Flowable<LoginBean>

    @POST("smsCode")
    @FormUrlEncoded
    fun getSmsCode(@Field("phone") phone:String):Flowable<CodeBean>




}