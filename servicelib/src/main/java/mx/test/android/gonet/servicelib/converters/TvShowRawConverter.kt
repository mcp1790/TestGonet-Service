package mx.test.android.gonet.servicelib.converters

import mx.test.android.gonet.domainlib.models.TvShowRawModel
import mx.test.android.gonet.servicelib.entity.response.TvShowRawResponseEntity

object TvShowRawConverter: IConverter<TvShowRawResponseEntity, TvShowRawModel> {
    override fun entityToModel(entityIn: TvShowRawResponseEntity?): TvShowRawModel {
        return entityIn?.let { entity ->
            TvShowRawModel(
                backdropPath = entity.backdrop_path ?: "",
                firstAirDate = entity.first_air_date ?: "",
                genreids = entity.genre_ids ?: listOf(),
                id = entity.id ?: -1,
                name = entity.name ?: "",
                originCountry = entity.origin_country ?: listOf(),
                originalLanguage = entity.original_language ?: "",
                originalName = entity.original_name ?: "",
                overview = entity.overview ?: "",
                popularity = entity.popularity ?: -1.0,
                posterPath = entity.poster_path ?: "",
                voteAverage = entity.vote_average ?: -1.0,
                voteCount = entity.vote_count ?: -1
            )
        } ?: TvShowRawModel()
    }

    override fun modelToEntity(modelIn: TvShowRawModel): TvShowRawResponseEntity {
        return TvShowRawResponseEntity()
    }
}