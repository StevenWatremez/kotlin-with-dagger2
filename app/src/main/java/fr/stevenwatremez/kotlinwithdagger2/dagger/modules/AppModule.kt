package fr.stevenwatremez.kotlinwithdagger2.dagger.modules

import android.app.Application
import javax.inject.Singleton
import dagger.Provides
import dagger.Module

@Module
class AppModule(var application: Application) {

  @Provides
  @Singleton
  internal fun providesApplication(): Application = application
}