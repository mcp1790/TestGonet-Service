package mx.test.android.gonet.servicelib.entity.response.child

import kotlinx.serialization.Serializable

@Serializable
class NetworkEntity {
    var id: Int? = -1
    var logo_path: String? = ""
    var name: String? = ""
    var origin_country: String? = ""
}