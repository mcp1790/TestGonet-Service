package mx.test.android.gonet.servicelib.converters

import mx.test.android.gonet.domainlib.models.child.ProductionCompanyModel
import mx.test.android.gonet.servicelib.entity.response.child.ProductionCompanyEntity

object ProductionCompanyConverter: IConverter<ProductionCompanyEntity, ProductionCompanyModel> {
    override fun entityToModel(entityIn: ProductionCompanyEntity?): ProductionCompanyModel {
        return entityIn?.let { entity->
            ProductionCompanyModel(
                id = entity.id ?: -1,
                logoPath = entity.logo_path ?: "",
                name = entity.name ?: "",
                originCountry = entity.origin_country ?: ""
            )
        } ?: ProductionCompanyModel()
    }

    override fun modelToEntity(modelIn: ProductionCompanyModel): ProductionCompanyEntity {
        return ProductionCompanyEntity()
    }
}