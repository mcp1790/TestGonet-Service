package mx.test.android.gonet.servicelib.converters

import mx.test.android.gonet.domainlib.models.ListMoviesModel
import mx.test.android.gonet.servicelib.entity.response.ListMoviesResponseEntity

object ListMoviesConverter : IConverter<ListMoviesResponseEntity, ListMoviesModel> {
    override fun entityToModel(entityIn: ListMoviesResponseEntity?): ListMoviesModel {
        return entityIn?.let { entity ->
            ListMoviesModel(
                results = entity.results?.map { MovieRawConverter.entityToModel(it) } ?: listOf(),
                totalPages = entity.total_pages ?: -1,
                totalResults = entity.total_results ?: -1,
                page = entity.page ?: -1,
                dates = DatesConverter.entityToModel(entity.dates)
            )
        } ?: ListMoviesModel()
    }

    override fun modelToEntity(modelIn: ListMoviesModel): ListMoviesResponseEntity {
        return ListMoviesResponseEntity()
    }
}