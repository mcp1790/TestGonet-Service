package mx.test.android.gonet.servicelib.converters

import mx.test.android.gonet.domainlib.models.TvShowDetailModel
import mx.test.android.gonet.domainlib.models.child.*
import mx.test.android.gonet.servicelib.entity.response.TvShowDetailResponseEntity

object TvShowDetailConverter: IConverter<TvShowDetailResponseEntity, TvShowDetailModel> {
    override fun entityToModel(entityIn: TvShowDetailResponseEntity?): TvShowDetailModel {
        return entityIn?.let { entity ->
            TvShowDetailModel(
                backdropPath = entity.backdrop_path ?: "",
                createdBy = entity.created_by?.map { CreatedByConverter.entityToModel(it) } ?: listOf(),
                episodeRunTime = entity.episode_run_time?.map { it } ?: listOf(),
                firstAirDate = entity.first_air_date ?: "",
                genres = entity.genres?.map { GenreConverter.entityToModel(it) } ?: listOf(),
                homepage = entity.homepage ?: "",
                id = entity.id ?: -1,
                inProduction = entity.in_production ?: false,
                languages = entity.languages?.map { it } ?: listOf(),
                lastAirDate = entity.lastA_air_date ?: "",
                lastEpisodeToAir = LastEpisodeOnAirConverter.entityToModel(entity.last_episode_to_air),
                name = entity.name ?: "",
                networks = entity.networks?.map { NetworkModelConverter.entityToModel(it) } ?: listOf(),
                numberOfEpisodes = entity.number_of_episodes ?: -1,
                numberOfSeasons = entity.number_of_seasons ?: -1,
                originCountry = entity.origin_country?.map { it } ?: listOf(),
                originalLanguage = entity.original_language ?: "",
                originalName = entity.original_name ?: "",
                overview = entity.overview ?: "",
                popularity = entity.popularity ?: -1.0,
                posterPath = entity.poster_path ?: "",
                productionCompanies = entity.production_companies?.map { ProductionCompanyConverter.entityToModel(it) } ?: listOf(),
                productionCountries = entity.production_countries?.map { ProductionCountryConverter.entityToModel(it) } ?: listOf(),
                seasons = entity.seasons?.map { SeasonConverter.entityToModel(it) } ?: listOf(),
                spokenLanguages = entity.spoken_languages?.map { SpokenLanguagesConverter.entityToModel(it) } ?: listOf(),
                status = entity.status ?: "",
                tagline = entity.tagline ?: "",
                type = entity.type ?: "",
                voteAverage = entity.vote_average ?: -1.0,
                voteCount =entity.vote_count ?:  -1
            )
        } ?: TvShowDetailModel()
    }

    override fun modelToEntity(modelIn: TvShowDetailModel): TvShowDetailResponseEntity {
        return TvShowDetailResponseEntity()
    }
}