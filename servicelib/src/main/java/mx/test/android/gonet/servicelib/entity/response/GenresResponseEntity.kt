package mx.test.android.gonet.servicelib.entity.response

import mx.test.android.gonet.servicelib.entity.response.child.GenreEntity

class GenresResponseEntity: BaseResponse() {
    var genres: List<GenreEntity>?= listOf()
}