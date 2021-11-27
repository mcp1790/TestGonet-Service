package mx.test.android.gonet.servicelib.converters

import mx.test.android.gonet.domainlib.models.ListMoviesModel
import mx.test.android.gonet.domainlib.models.ListTvShowsModel
import mx.test.android.gonet.servicelib.entity.response.ListMoviesResponseEntity
import mx.test.android.gonet.servicelib.entity.response.ListTvShowsResponseEntity

object ListTvShowConverter : IConverter<ListTvShowsResponseEntity, ListTvShowsModel> {
    override fun entityToModel(entityIn: ListTvShowsResponseEntity?): ListTvShowsModel {
        return entityIn?.let { entity ->
            ListTvShowsModel(
                results = entity.results?.map { TvShowRawConverter.entityToModel(it) } ?: listOf(),
                totalPages = entity.total_pages ?: -1,
                totalResults = entity.total_results ?: -1,
                page = entity.page ?: -1
            )
        } ?: ListTvShowsModel()
    }

    override fun modelToEntity(modelIn: ListTvShowsModel): ListTvShowsResponseEntity {
        return ListTvShowsResponseEntity()
    }
}