package mx.test.android.gonet.servicelib.converters

import mx.test.android.gonet.domainlib.models.child.LastEpisodeToAirModel
import mx.test.android.gonet.servicelib.entity.response.child.LastEpisodeToAirEntity

object LastEpisodeOnAirConverter: IConverter<LastEpisodeToAirEntity, LastEpisodeToAirModel> {
    override fun entityToModel(entityIn: LastEpisodeToAirEntity?): LastEpisodeToAirModel {
        return entityIn?.let { entity ->
            LastEpisodeToAirModel(
                airDate = entity.air_date ?: "",
                episodeNumber = entity.episode_number ?: -1,
                id = entity.id ?: -1,
                name = entity.name ?: "",
                overview = entity.overview ?: "",
                productionCode = entity.production_code ?: "",
                seasonNumber = entity.season_number ?: -1,
                stillPath = entity.still_path ?: "",
                voteAverage = entity.vote_average ?: -1.0,
                voteCount = entity.vote_count ?: -1
            )
        } ?: LastEpisodeToAirModel()
    }

    override fun modelToEntity(modelIn: LastEpisodeToAirModel): LastEpisodeToAirEntity {
        TODO("Not yet implemented")
    }
}