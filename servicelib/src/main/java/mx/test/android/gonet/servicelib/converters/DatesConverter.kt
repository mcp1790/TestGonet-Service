package mx.test.android.gonet.servicelib.converters

import mx.test.android.gonet.domainlib.models.child.DatesModel
import mx.test.android.gonet.servicelib.entity.response.child.DatesEntity

object DatesConverter: IConverter<DatesEntity, DatesModel> {
    override fun entityToModel(entityIn: DatesEntity?): DatesModel {
        return entityIn?.let {
            DatesModel(
                maximum = it.maximum ?: "",
                minimum = it.minimum ?: ""
            )
        } ?: DatesModel()
    }

    override fun modelToEntity(modelIn: DatesModel): DatesEntity {
        return DatesEntity()
    }
}