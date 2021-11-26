package mx.test.android.gonet.servicelib.converters

import mx.test.android.gonet.domainlib.models.child.GenreModel
import mx.test.android.gonet.servicelib.entity.response.child.GenreEntity

object GenreConverter: IConverter<GenreEntity, GenreModel> {
    override fun entityToModel(entityIn: GenreEntity?): GenreModel {
        return entityIn?.let {
            GenreModel(
                id = it.id ?: -1,
                name = it.name ?: ""
            )
        } ?: GenreModel()
    }

    override fun modelToEntity(modelIn: GenreModel): GenreEntity {
        return GenreEntity()
    }
}