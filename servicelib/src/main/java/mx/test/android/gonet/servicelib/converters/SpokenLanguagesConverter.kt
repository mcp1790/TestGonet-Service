package mx.test.android.gonet.servicelib.converters

import mx.test.android.gonet.domainlib.models.child.SpokenLanguageModel
import mx.test.android.gonet.servicelib.entity.response.child.SpokenLanguageEntity

object SpokenLanguagesConverter: IConverter<SpokenLanguageEntity, SpokenLanguageModel> {
    override fun entityToModel(entityIn: SpokenLanguageEntity?): SpokenLanguageModel {
        return entityIn?.let { entity ->
            SpokenLanguageModel(
                englishName = entity.english_name ?: "",
                iso6391 = entity.iso_639_1 ?: "",
                name = entity.name ?: ""
            )
        } ?: SpokenLanguageModel()
    }

    override fun modelToEntity(modelIn: SpokenLanguageModel): SpokenLanguageEntity {
        return SpokenLanguageEntity()
    }
}