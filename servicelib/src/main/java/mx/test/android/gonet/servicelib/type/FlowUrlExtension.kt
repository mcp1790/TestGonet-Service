package mx.test.android.gonet.servicelib.type

import android.content.Context
import mx.test.android.gonet.servicelib.config.Utils

fun FlowEnum.url(id: String? = null, context: Context): String{

    val urlBase = Utils.extractConfigUrlFile(context).urls?.first()!!

    return when(this){
        FlowEnum.MovieDetails -> urlBase.plus("movie")
        FlowEnum.MoviesTopRated -> urlBase.plus("movie/top_rated")
        FlowEnum.MoviesPopular -> urlBase.plus("movie/popular")
        FlowEnum.MoviesRecommendation -> urlBase.plus("movie/$id/recommendations")
        FlowEnum.MoviesLatest -> urlBase.plus("movie/latest")
        FlowEnum.TvShowDetails -> urlBase.plus("tv")
        FlowEnum.TvShowsTopRated -> urlBase.plus("tv/top_rated")
        FlowEnum.TvShowLatest -> urlBase.plus("tv/latest")
        FlowEnum.TvShowsPopular -> urlBase.plus("tv/popular")
        FlowEnum.TvShowsRecommendation -> urlBase.plus("tv/$id/recommendations")
        FlowEnum.MoviesUpcoming -> urlBase.plus("movie/upcoming")
        FlowEnum.TvShowsOnAir -> urlBase.plus("tv/on_the_air")
        FlowEnum.MoviesGenres -> urlBase.plus("genre/movie/list")
        FlowEnum.TvShowGenres -> urlBase.plus("genre/tv/list")
    }
}