package mx.test.android.gonet.servicelib.config

import kotlinx.serialization.Serializable

@Serializable
class ConfigUrlEntity {
    var urls: List<String>?     = listOf()
    var time_out_interval: Int? = -1
    var version: String? = null
    var enable_logs: Boolean? = false
}