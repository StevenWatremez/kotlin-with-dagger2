package fr.stevenwatremez.kotlinwithdagger2.dagger.modules

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule {

  // Dagger will only look for methods annotated with @Provides
  @Provides
  @Singleton
  internal fun providesSharedPreferences(application: Application):
      // Application reference must come from AppModule.class
      SharedPreferences = PreferenceManager.getDefaultSharedPreferences(application)

  @Provides
  @Singleton
  internal fun provideOkHttpCache(application: Application): Cache {
    val cacheSize: Long = 10 * 1024 * 1024 // 10 MiB
    val cache = Cache(application.cacheDir, cacheSize)
    return cache
  }

  @Provides
  @Singleton
  internal fun provideGson(): Gson =
      GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()

  @Provides
  @Singleton
  internal fun provideOkHttpClient(cache: Cache): OkHttpClient =
      OkHttpClient().newBuilder().cache(cache).build()

  @Provides
  @Singleton
  internal fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit =
      Retrofit.Builder()
          .addConverterFactory(GsonConverterFactory.create(gson))
          .baseUrl("http://watremez.fr/api/v1")
          .client(okHttpClient)
          .build()
}