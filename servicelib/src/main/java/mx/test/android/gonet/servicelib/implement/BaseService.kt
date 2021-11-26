package mx.test.android.gonet.servicelib.implement

import android.content.Context
import mx.test.android.gonet.servicelib.config.ServiceEndPoints
import mx.test.android.gonet.servicelib.di.DaggerServiceComponent
import mx.test.android.gonet.servicelib.di.ServiceModule
import java.io.UnsupportedEncodingException
import java.net.URLEncoder
import javax.inject.Inject

open class BaseService(context: Context) {

    internal val apiKey = "d74cfbdca46ca0c4b168810b22023d7c"
    internal val genericMessageNullResponse = "Response is null"

    @Inject
    internal lateinit var service: ServiceEndPoints

    init {
        DaggerServiceComponent.builder()
            .serviceModule(ServiceModule(context))
            .build()
            .inject(service = this)
    }

    fun urlEncodeUTF8(map: Map<*, *>): String? {
        val sb = StringBuilder()
        for ((key, value) in map) {
            if (value.toString().isNotEmpty()) {
                sb.append(if (sb.isEmpty()) "?" else "&")
                sb.append(
                    String.format(
                        "%s=%s",
                        urlEncodeUTF8(key.toString()),
                        urlEncodeUTF8(value.toString())
                    )
                )
            }
        }

        return sb.toString()
    }

    private fun urlEncodeUTF8(s: String?): String? {
        return try {
            URLEncoder.encode(s, "UTF-8")
        } catch (e: UnsupportedEncodingException) {
            throw UnsupportedOperationException(e)
        }
    }
}