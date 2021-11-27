package mx.test.android.gonet.servicelib

import io.reactivex.schedulers.Schedulers
import junit.framework.TestCase
import mx.test.android.gonet.servicelib.type.FlowEnum
import org.junit.Assert
import org.junit.Test
import kotlin.jvm.Throws

class TvShowsServiceTest: BaseServiceTest() {

    @Test(timeout = 3000000)
    @Throws(InterruptedException::class)
    fun tvShowDetailsTest() {
        tvShowsService.tvShowDetails("20")
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
    fun tvShowLatestTest() {
        tvShowsService.tvShowLatest()
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
    fun tvShowGenresTest() {
        tvShowsService.listOfTvShowGenres()
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
        tvShowsService.listOfTvShows(
            flow = FlowEnum.TvShowsPopular,
            idRecommended = "500",
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