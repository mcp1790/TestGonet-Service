package mx.test.android.gonet.servicelib.entity.response.child

import kotlinx.serialization.Serializable

@Serializable
class CreatedByEntity {
    var credit_id: String? = ""
    var gender: Int? = -1
    var id: Int? = -1
    var name: String? = ""
    var profile_path: String? = ""
}