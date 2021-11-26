package mx.test.android.gonet.servicelib.di

import dagger.Component
import mx.test.android.gonet.servicelib.implement.BaseService
import javax.inject.Singleton

@Singleton
@Component(modules = [ServiceModule::class])
interface ServiceComponent {
    fun inject(service: BaseService)
}