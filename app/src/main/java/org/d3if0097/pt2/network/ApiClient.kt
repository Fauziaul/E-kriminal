package org.d3if0097.pt2.network

import android.provider.ContactsContract.CommonDataKinds.Email
import org.d3if0097.pt2.model.ResponseLogin
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiClient {

    @FormUrlEncoded
//    @POST("ekriminal/creatData.php")
//    fun register(
//        @Field("email") email : String,
//        @Field("username") username : String,
//        @Field("phone") phone : Int,
//        @Field("password") password: String,
//
//    )

    @POST("ekriminal/chekLogin.php")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Call<ResponseLogin>
}