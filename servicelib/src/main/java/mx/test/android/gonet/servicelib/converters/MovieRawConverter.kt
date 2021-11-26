package mx.test.android.gonet.servicelib.converters

import mx.test.android.gonet.domainlib.models.MovieRawModel
import mx.test.android.gonet.servicelib.entity.response.MovieRawEntityResponse

object MovieRawConverter : IConverter<MovieRawEntityResponse, MovieRawModel> {
    override fun entityToModel(entityIn: MovieRawEntityResponse?): MovieRawModel {
        return entityIn?.let { entity ->
            MovieRawModel(
                adult = entity.adult ?: false,
                backdropPath = entity.backdrop_path ?: "",
                budget = entity.budget ?: -1,
                genres = entity.genres?.map { GenreConverter.entityToModel(it) } ?: listOf(),
                homepage = entity.homepage ?: "",
                id = entity.id ?: -1,
                imdbId = entity.imdb_id ?: "",
                originalLanguage = entity.original_language ?: "",
                originalTitle = entity.original_title ?: "",
                overview = entity.overview ?: "",
                popularity = entity.popularity ?: -1.0,
                posterPath = entity.poster_path ?: "",
                productionCompanies = entity.production_companies?.map { ProductionCompanyConverter.entityToModel(it) } ?: listOf(),
                productionCountries = entity.production_countries?.map { ProductionCountryConverter.entityToModel(it) } ?: listOf(),
                releaseDate = entity.release_date ?: "",
                revenue = entity.revenue ?: -1,
                runtime = entity.runtime ?: -1,
                spokenLanguages = entity.spoken_languages?.map { SpokenLanguagesConverter.entityToModel(it) } ?: listOf(),
                status = entity.status ?: "",
                tagline = entity.tagline ?: "",
                title = entity.title ?: "",
                video = entity.video ?: false,
                voteAverage = entity.vote_average ?: -1.0,
                voteCount = entity.vote_count ?: -1
            )
        } ?: MovieRawModel()
    }

    override fun modelToEntity(modelIn: MovieRawModel): MovieRawEntityResponse {
        return MovieRawEntityResponse(

        )
    }
}