package mx.test.android.gonet.servicelib.entity.response

import kotlinx.serialization.Serializable
import mx.test.android.gonet.servicelib.entity.response.child.*

@Serializable
class TvShowDetailResponseEntity: BaseResponse()  {
    var backdrop_path: String? = ""
    var created_by: List<CreatedByEntity>? = listOf()
    var episode_run_time: List<Int>? = listOf()
    var first_air_date: String? = ""
    var genres: List<GenreEntity>? = listOf()
    var homepage: String? = ""
    var id: Int? = -1
    var in_production: Boolean? = false
    var languages: List<String>? = listOf()
    var lastA_air_date: String? = ""
    var last_episode_to_air: LastEpisodeToAirEntity? = null
    var name: String? = ""
    var networks: List<NetworkEntity>? = listOf()
    var number_of_episodes: Int? = -1
    var number_of_seasons: Int? = -1
    var origin_country: List<String>? = listOf()
    var original_language: String? = ""
    var original_name: String? = ""
    var overview: String? = ""
    var popularity: Double? = -1.0
    var poster_path: String? = ""
    var production_companies: List<ProductionCompanyEntity>? = listOf()
    var production_countries: List<ProductionCountryEntity>? = listOf()
    var seasons: List<SeasonEntity>? = listOf()
    var spoken_languages: List<SpokenLanguageEntity>? = listOf()
    var status: String? = ""
    var tagline: String? = ""
    var type: String? = ""
    var vote_average: Double? = -1.0
    var vote_count: Int? = -1
}