package mx.test.android.gonet.servicelib.converters

import mx.test.android.gonet.domainlib.models.child.CreatedByModel
import mx.test.android.gonet.servicelib.entity.response.child.CreatedByEntity

object CreatedByConverter: IConverter<CreatedByEntity, CreatedByModel> {
    override fun entityToModel(entityIn: CreatedByEntity?): CreatedByModel {
        return entityIn?.let { entity ->
            CreatedByModel(
                creditId = entity.credit_id ?: "",
                gender = entity.gender ?: -1,
                id = entity.id ?: -1,
                name = entity.name ?: "",
                profilePath = entity.profile_path ?: ""
            )
        } ?: CreatedByModel()
    }

    override fun modelToEntity(modelIn: CreatedByModel): CreatedByEntity {
        return CreatedByEntity()
    }
}