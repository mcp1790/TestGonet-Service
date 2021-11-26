package mx.test.android.gonet.servicelib

import dagger.Component
import mx.test.android.gonet.servicelib.di.ServiceModule
import mx.test.android.gonet.servicelib.implement.BaseService
import javax.inject.Singleton

@Singleton
@Component(modules = [ServiceModule::class])
interface ServiceComponentTest {
    fun inject(service: BaseServiceTest)
}