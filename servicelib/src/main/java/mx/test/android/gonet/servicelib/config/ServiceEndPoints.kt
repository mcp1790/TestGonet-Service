package mx.test.android.gonet.servicelib.config

import io.reactivex.Observable
import retrofit2.http.*

interface ServiceEndPoints {
    @Headers("Content-Type: application/json")
    @POST
    fun postRequest(@Url url: String, @Body bodyParams: String): Observable<Any>?

    @GET
    @Headers("Content-Type: application/json")
    fun getRequest(@Url url: String): Observable<Any>?
}