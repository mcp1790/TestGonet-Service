package mx.test.android.gonet.servicelib.entity.response.child

import kotlinx.serialization.Serializable

@Serializable
class SeasonEntity {
    var air_date: String?  = ""
    var episode_count: Int?  = -1
    var id: Int?  = -1
    var name: String?  = ""
    var overview: String?  = ""
    var poster_path: String?  = ""
    var season_number: Int?  = -1
}