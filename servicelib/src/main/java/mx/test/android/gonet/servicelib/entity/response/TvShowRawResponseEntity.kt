package mx.test.android.gonet.servicelib.entity.response

import kotlinx.serialization.Serializable
import mx.test.android.gonet.servicelib.entity.response.child.GenreEntity

@Serializable
class TvShowRawResponseEntity: BaseResponse()  {
    var backdrop_path: String? = ""
    var first_air_date: String? = ""
    var genre_ids: List<Int>? = listOf()
    var genres: List<GenreEntity>? = listOf()
    var id: Int? = -1
    var name: String? = ""
    var origin_country: List<String>? = listOf()
    var original_language: String? = ""
    var original_name: String? = ""
    var overview: String? = ""
    var popularity: Double? = -1.0
    var poster_path: String? = ""
    var vote_average: Double? = -1.0
    var vote_count: Int? = -1
}