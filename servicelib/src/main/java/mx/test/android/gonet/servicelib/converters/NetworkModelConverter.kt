package mx.test.android.gonet.servicelib.converters

import mx.test.android.gonet.domainlib.models.child.NetworkModel
import mx.test.android.gonet.servicelib.entity.response.child.NetworkEntity

object NetworkModelConverter: IConverter<NetworkEntity, NetworkModel> {
    override fun entityToModel(entityIn: NetworkEntity?): NetworkModel {
        return entityIn?.let { entity ->
            NetworkModel(
                id = entity.id ?: -1,
                logoPath = entity.logo_path ?: "",
                name = entity.name ?: "",
                originCountry = entity.origin_country ?: "",
            )
        } ?: NetworkModel()
    }

    override fun modelToEntity(modelIn: NetworkModel): NetworkEntity {
        TODO("Not yet implemented")
    }
}