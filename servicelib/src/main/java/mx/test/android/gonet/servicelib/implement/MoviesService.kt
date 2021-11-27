package mx.test.android.gonet.servicelib.implement

import android.annotation.SuppressLint
import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import mx.test.android.gonet.domainlib.models.ListMoviesModel
import mx.test.android.gonet.domainlib.models.MovieRawModel
import mx.test.android.gonet.domainlib.models.child.GenreModel
import mx.test.android.gonet.servicelib.converters.GenreConverter
import mx.test.android.gonet.servicelib.converters.ListMoviesConverter
import mx.test.android.gonet.servicelib.converters.MovieRawConverter
import mx.test.android.gonet.servicelib.entity.response.GenresResponseEntity
import mx.test.android.gonet.servicelib.entity.response.ListMoviesResponseEntity
import mx.test.android.gonet.servicelib.entity.response.MovieRawEntityResponse
import mx.test.android.gonet.servicelib.type.FlowEnum
import mx.test.android.gonet.servicelib.type.url
import javax.inject.Inject

@SuppressLint("CheckResult")
class MoviesService @Inject constructor(var context: Context) : BaseService(context) {

    fun moviesDetails(movieId: String): Observable<MovieRawModel> {
        return Observable.unsafeCreate { subscriber ->
            val map: HashMap<String, Any?> = hashMapOf()
            map["api_key"] = apiKey

            val urlMovieDetails= FlowEnum.MovieDetails.url(context = context).plus("/$movieId").plus(this.urlEncodeUTF8(map))

            this.service.getRequest(
                url = urlMovieDetails
            )?.subscribeOn(Schedulers.io())
                ?.observeOn(Schedulers.io())
                ?.subscribe({ response ->
                    response?.let { responseRaw ->
                        val entityResponse = Gson().fromJson(
                            Gson().toJson(responseRaw),
                            MovieRawEntityResponse::class.java
                        )

                        subscriber.onNext(MovieRawConverter.entityToModel(entityResponse))
                    } ?: subscriber.onError(Throwable(genericMessageNullResponse))
                }, { error ->
                    subscriber.onError(Throwable(error.localizedMessage))
                })
        }
    }

    fun movieLatest(): Observable<MovieRawModel> {
        return Observable.unsafeCreate { subscriber ->
            val map: HashMap<String, Any?> = hashMapOf()
            map["api_key"] = apiKey

            val urlMovieDetails= FlowEnum.MoviesLatest.url(context = context).plus(this.urlEncodeUTF8(map))

            this.service.getRequest(
                url = urlMovieDetails
            )?.subscribeOn(Schedulers.io())
                ?.observeOn(Schedulers.io())
                ?.subscribe({ response ->
                    response?.let { responseRaw ->
                        val entityResponse = Gson().fromJson(
                            Gson().toJson(responseRaw),
                            MovieRawEntityResponse::class.java
                        )

                        subscriber.onNext(MovieRawConverter.entityToModel(entityResponse))
                    } ?: subscriber.onError(Throwable(genericMessageNullResponse))
                }, { error ->
                    subscriber.onError(Throwable(error.localizedMessage))
                })
        }
    }

    fun listOfMovies(flow: FlowEnum, idRecommended: String, page: Int): Observable<ListMoviesModel>{
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
                            ListMoviesResponseEntity::class.java
                        )

                        subscriber.onNext(ListMoviesConverter.entityToModel(entityResponse))
                    } ?: subscriber.onError(Throwable(genericMessageNullResponse))
                }, { error ->
                    subscriber.onError(Throwable(error.localizedMessage))
                })
        }
    }

    fun listOfMoviesGenres(): Observable<List<GenreModel>>{
        return Observable.unsafeCreate { subscriber ->
            val map: HashMap<String, Any?> = hashMapOf()
            map["api_key"] = apiKey
            this.service.getRequest(
                url = FlowEnum.MoviesGenres.url(context = context).plus(this.urlEncodeUTF8(map))
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