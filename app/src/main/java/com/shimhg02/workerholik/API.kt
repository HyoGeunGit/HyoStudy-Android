package com.shimhg02.workerholik



import retrofit2.Call
import retrofit2.http.*


interface API {

    @POST("/signin")
    @FormUrlEncoded
    fun logIn(@Field("id") id : String, @Field("passwd") pw : String) :  Call<Login>

    @POST("/signup")
    @FormUrlEncoded
    fun logUp(@Field("name") name: String?, @Field("id") id: String?, @Field("passwd") pw: String?, @Field("phoneNum") ph: String?) :  Call<Void>

    @POST("/allHealthList")
    @FormUrlEncoded
    fun getData(@Field("userToken") token :String?) : Call<ArrayList<ProfileData>>

}