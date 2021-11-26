package mx.test.android.gonet.servicelib

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import mx.test.android.gonet.servicelib.di.ServiceModule
import mx.test.android.gonet.servicelib.implement.MoviesService
import mx.test.android.gonet.servicelib.implement.TvShowsService
import org.junit.Before
import javax.inject.Inject

open class BaseServiceTest {
    private lateinit var appContext: Context
    protected var _syncObject = Object()

    @Inject
    lateinit var moviesService: MoviesService
    @Inject
    lateinit var tvShowsService: TvShowsService

    @Before
    fun setUp() {
        appContext  = InstrumentationRegistry.getInstrumentation().targetContext
        DaggerServiceComponentTest.builder()
            .serviceModule(ServiceModule(appContext))
            .build()
            .inject(this)
    }
}