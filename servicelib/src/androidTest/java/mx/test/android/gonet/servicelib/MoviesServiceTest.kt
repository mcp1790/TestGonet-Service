package mx.test.android.gonet.servicelib

import io.reactivex.schedulers.Schedulers
import junit.framework.TestCase
import mx.test.android.gonet.servicelib.type.FlowEnum
import org.junit.Assert
import org.junit.Test
import kotlin.jvm.Throws

class MoviesServiceTest: BaseServiceTest() {

    @Test(timeout = 3000000)
    @Throws(InterruptedException::class)
    fun moviesDetailsTest() {
        moviesService.moviesDetails("20")
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({
                TestCase.assertTrue(true)

                synchronized(_syncObject) { _syncObject.notify() }
            },{
                Assert.fail("error.localizedMessage")

                synchronized(_syncObject) { _syncObject.notify() }
            })
    }

    @Test(timeout = 3000000)
    @Throws(InterruptedException::class)
    fun movieLatestTest() {
        moviesService.movieLatest()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({
                TestCase.assertTrue(true)

                synchronized(_syncObject) { _syncObject.notify() }
            },{
                Assert.fail("error.localizedMessage")

                synchronized(_syncObject) { _syncObject.notify() }
            })
    }

    @Test(timeout = 3000000)
    @Throws(InterruptedException::class)
    fun moviesGenresTest() {
        moviesService.listOfMoviesGenres()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({
                TestCase.assertTrue(true)

                synchronized(_syncObject) { _syncObject.notify() }
            },{
                Assert.fail("error.localizedMessage")

                synchronized(_syncObject) { _syncObject.notify() }
            })
    }


    @Test(timeout = 3000000)
    @Throws(InterruptedException::class)
    fun moviesListTest() {
        moviesService.listOfMovies(
            flow = FlowEnum.MoviesPopular,
            idRecommended = "",
            page = 1
        ).subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({
                TestCase.assertTrue(true)

                synchronized(_syncObject) { _syncObject.notify() }
            },{
                Assert.fail("error.localizedMessage")

                synchronized(_syncObject) { _syncObject.notify() }
            })
    }
}