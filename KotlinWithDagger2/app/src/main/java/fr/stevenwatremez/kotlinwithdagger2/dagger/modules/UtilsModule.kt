package fr.stevenwatremez.kotlinwithdagger2.dagger.modules

import dagger.Module
import dagger.Provides
import fr.stevenwatremez.kotlinwithdagger2.utils.StringFactory
import javax.inject.Singleton

@Module
class UtilsModule {
  @Provides
  @Singleton
  internal fun provideStringFactory(): StringFactory = StringFactory()
}