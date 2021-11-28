package mx.test.android.gonet.servicelib.converters

import mx.test.android.gonet.domainlib.models.child.SeasonModel
import mx.test.android.gonet.servicelib.entity.response.child.SeasonEntity

object SeasonConverter: IConverter<SeasonEntity, SeasonModel> {
    override fun entityToModel(entityIn: SeasonEntity?): SeasonModel {
        return entityIn?.let { entity ->
            SeasonModel(
                airDate = entity.air_date ?: "",
                episodeCount = entity.episode_count ?: -1,
                id = entity.id ?: -1,
                name = entity.name ?: "",
                overview = entity.overview ?: "",
                posterPath = entity.poster_path ?: "",
                seasonNumber = entity.season_number ?: -1,
            )
        } ?: SeasonModel()
    }

    override fun modelToEntity(modelIn: SeasonModel): SeasonEntity {
        TODO("Not yet implemented")
    }
}