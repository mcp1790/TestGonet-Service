package mx.test.android.gonet.servicelib.entity.response

import com.google.gson.GsonBuilder
import kotlinx.serialization.Serializable
import mx.test.android.gonet.servicelib.entity.response.child.DatesEntity

@Serializable
open class BaseResponse {
    var status_message: String? = ""
    var status_code: Int? = -1

    var page: Int? = -1
    var total_pages: Int? = -1
    var total_results: Int? = -1
    var dates: DatesEntity? = null

    override fun toString(): String {
        return GsonBuilder().disableHtmlEscaping().create().toJson(this)
    }
}