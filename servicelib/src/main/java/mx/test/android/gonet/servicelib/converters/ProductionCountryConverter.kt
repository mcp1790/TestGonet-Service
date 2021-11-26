package mx.test.android.gonet.servicelib.converters

import mx.test.android.gonet.domainlib.models.child.ProductionCountryModel
import mx.test.android.gonet.servicelib.entity.response.child.ProductionCountryEntity

object ProductionCountryConverter: IConverter<ProductionCountryEntity, ProductionCountryModel> {
    override fun entityToModel(entityIn: ProductionCountryEntity?): ProductionCountryModel {
        return entityIn?.let { entity->
            ProductionCountryModel(
                iso31661 = entity.iso_3166_1 ?: "",
                name = entity.name ?: ""
            )
        } ?: ProductionCountryModel()
    }

    override fun modelToEntity(modelIn: ProductionCountryModel): ProductionCountryEntity {
        return ProductionCountryEntity()
    }
}