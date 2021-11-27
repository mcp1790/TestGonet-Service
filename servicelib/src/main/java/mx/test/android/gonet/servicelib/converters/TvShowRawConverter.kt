package mx.test.android.gonet.servicelib.converters

import mx.test.android.gonet.domainlib.models.TvShowRawModel
import mx.test.android.gonet.domainlib.models.child.GenreModel
import mx.test.android.gonet.servicelib.entity.response.TvShowRawResponseEntity

object TvShowRawConverter: IConverter<TvShowRawResponseEntity, TvShowRawModel> {
    override fun entityToModel(entityIn: TvShowRawResponseEntity?): TvShowRawModel {

        return entityIn?.let { entity ->
            var genresList = arrayListOf<GenreModel>()
            if (entity.genre_ids?.isNotEmpty()!!){
                entity.genre_ids?.forEach {
                    genresList.add(
                        GenreModel().apply {
                            id = it
                        }
                    )
                }
            } else {
                genresList = entity.genres?.map { GenreConverter.entityToModel(it) }?.toCollection(ArrayList()) ?: arrayListOf()
            }
            TvShowRawModel(
                backdropPath = entity.backdrop_path ?: "",
                firstAirDate = entity.first_air_date ?: "",
                genres = genresList.toList(),
                id = entity.id ?: -1,
                name = entity.name ?: "",
                originCountry = entity.origin_country ?: listOf(),
                originalLanguage = entity.original_language ?: "",
                originalName = entity.original_name ?: "",
                overview = entity.overview ?: "",
                popularity = entity.popularity ?: -1.0,
                posterPath = entity.poster_path ?: "",
                voteAverage = entity.vote_average ?: -1.0,
                voteCount = entity.vote_count ?: -1,

            )
        } ?: TvShowRawModel()
    }

    override fun modelToEntity(modelIn: TvShowRawModel): TvShowRawResponseEntity {
        return TvShowRawResponseEntity()
    }
}