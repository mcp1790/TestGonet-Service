package mx.test.android.gonet.servicelib.di

import android.content.Context
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import mx.test.android.gonet.servicelib.config.ServiceEndPoints
import mx.test.android.gonet.servicelib.config.Utils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ServiceModule(var context: Context) {
    @Provides
    fun provideContext() = context

    @Provides
    fun provideHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.MINUTES)
            .readTimeout(20, TimeUnit.MINUTES)
            .writeTimeout(19, TimeUnit.MINUTES)

        if (Utils.extractConfigUrlFile(context).enable_logs!!)
            client.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        return client.build()
    }

    @Provides
    fun provideRetrofitInstance(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Utils.defaultBaseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(
                GsonBuilder()
                    .setLenient()
                    .create())
            ).client(client)
            .build()
    }

    @Provides
    fun provideEndPoints(): ServiceEndPoints {
        return provideRetrofitInstance(
            provideHttpClient()
        ).create(ServiceEndPoints::class.java)
    }

}