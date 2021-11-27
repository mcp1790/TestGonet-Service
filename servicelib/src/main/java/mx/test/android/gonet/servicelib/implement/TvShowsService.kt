package mx.test.android.gonet.servicelib.implement

import android.annotation.SuppressLint
import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import mx.test.android.gonet.domainlib.models.ListMoviesModel
import mx.test.android.gonet.domainlib.models.ListTvShowsModel
import mx.test.android.gonet.domainlib.models.MovieRawModel
import mx.test.android.gonet.domainlib.models.TvShowRawModel
import mx.test.android.gonet.domainlib.models.child.GenreModel
import mx.test.android.gonet.servicelib.converters.*
import mx.test.android.gonet.servicelib.entity.response.*
import mx.test.android.gonet.servicelib.entity.response.child.GenreEntity
import mx.test.android.gonet.servicelib.type.FlowEnum
import mx.test.android.gonet.servicelib.type.url
import javax.inject.Inject

@SuppressLint("CheckResult")
class TvShowsService @Inject constructor(var context: Context) : BaseService(context) {

    fun tvShowDetails(tvShowId: String): Observable<TvShowRawModel> {
        return Observable.unsafeCreate { subscriber ->
            val map: HashMap<String, Any?> = hashMapOf()
            map["api_key"] = apiKey

            this.service.getRequest(
                url = FlowEnum.TvShowDetails.url(context = context).plus("/$tvShowId").plus(this.urlEncodeUTF8(map))
            )?.subscribeOn(Schedulers.io())
                ?.observeOn(Schedulers.io())
                ?.subscribe({ response ->
                    response?.let { responseRaw ->
                        val entityResponse = Gson().fromJson(
                            Gson().toJson(responseRaw),
                            TvShowRawResponseEntity::class.java
                        )

                        subscriber.onNext(TvShowRawConverter.entityToModel(entityResponse))
                    } ?: subscriber.onError(Throwable(genericMessageNullResponse))
                }, { error ->
                    subscriber.onError(Throwable(error.localizedMessage))
                })
        }
    }

    fun tvShowLatest(): Observable<TvShowRawModel> {
        return Observable.unsafeCreate { subscriber ->
            val map: HashMap<String, Any?> = hashMapOf()
            map["api_key"] = apiKey

            this.service.getRequest(
                url = FlowEnum.TvShowLatest.url(context = context).plus(this.urlEncodeUTF8(map))
            )?.subscribeOn(Schedulers.io())
                ?.observeOn(Schedulers.io())
                ?.subscribe({ response ->
                    response?.let { responseRaw ->
                        val entityResponse = Gson().fromJson(
                            Gson().toJson(responseRaw),
                            TvShowRawResponseEntity::class.java
                        )

                        subscriber.onNext(TvShowRawConverter.entityToModel(entityResponse))
                    } ?: subscriber.onError(Throwable(genericMessageNullResponse))
                }, { error ->
                    subscriber.onError(Throwable(error.localizedMessage))
                })
        }
    }

    fun listOfTvShows(flow: FlowEnum, idRecommended: String, page: Int): Observable<ListTvShowsModel>{
        return Observable.unsafeCreate { subscriber ->
            val map: HashMap<String, Any?> = hashMapOf()
            map["api_key"] = apiKey
            map["page"] = page

            this.service.getRequest(
                url = flow.url(idRecommended, context = context).plus(this.urlEncodeUTF8(map))
            )?.subscribeOn(Schedulers.io())
                ?.observeOn(Schedulers.io())
                ?.subscribe({ response ->
                    response?.let { responseRaw ->
                        val entityResponse = Gson().fromJson(
                            Gson().toJson(responseRaw),
                            ListTvShowsResponseEntity::class.java
                        )

                        subscriber.onNext(ListTvShowConverter.entityToModel(entityResponse))
                    } ?: subscriber.onError(Throwable(genericMessageNullResponse))
                }, { error ->
                    subscriber.onError(Throwable(error.localizedMessage))
                })
        }
    }

    fun listOfTvShowGenres(): Observable<List<GenreModel>>{
        return Observable.unsafeCreate { subscriber ->
            val map: HashMap<String, Any?> = hashMapOf()
            map["api_key"] = apiKey
            this.service.getRequest(
                url = FlowEnum.TvShowGenres.url(context = context).plus(this.urlEncodeUTF8(map))
            )?.subscribeOn(Schedulers.io())
                ?.observeOn(Schedulers.io())
                ?.subscribe({ response ->
                    response?.let { responseRaw ->
                        val entityResponse = Gson().fromJson(
                            Gson().toJson(responseRaw),
                            GenresResponseEntity::class.java
                        )

                        subscriber.onNext(entityResponse.genres?.map { GenreConverter.entityToModel(it) })
                    } ?: subscriber.onError(Throwable(genericMessageNullResponse))
                }, { error ->
                    subscriber.onError(Throwable(error.localizedMessage))
                })
        }
    }


}