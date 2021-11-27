package mx.test.android.gonet.servicelib.entity.response

import kotlinx.serialization.Serializable
import mx.test.android.gonet.servicelib.entity.response.child.GenreEntity
import mx.test.android.gonet.servicelib.entity.response.child.ProductionCompanyEntity
import mx.test.android.gonet.servicelib.entity.response.child.ProductionCountryEntity
import mx.test.android.gonet.servicelib.entity.response.child.SpokenLanguageEntity

@Serializable
class MovieRawEntityResponse: BaseResponse() {
    var adult: Boolean? = false
    var backdrop_path: String? = ""
    var budget: Int? = -1
    var genre_ids: List<Int>? = listOf()
    var genres: List<GenreEntity>? = listOf()
    var homepage: String? = ""
    var id: Int? = -1
    var imdb_id: String? = ""
    var original_language: String? = ""
    var original_title: String? = ""
    var overview: String? = ""
    var popularity: Double? = -1.0
    var poster_path: String? = ""
    var production_companies: List<ProductionCompanyEntity>? = listOf()
    var production_countries: List<ProductionCountryEntity>? = listOf()
    var release_date: String? = ""
    var revenue: Int? = -1
    var runtime: Int? = -1
    var spoken_languages: List<SpokenLanguageEntity>? = listOf()
    var status: String? = ""
    var tagline: String? = ""
    var title: String? = ""
    var video: Boolean? = false
    var vote_average: Double? = -1.0
    var vote_count: Int? = -1
}