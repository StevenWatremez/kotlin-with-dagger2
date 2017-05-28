package fr.stevenwatremez.kotlinwithdagger2.app

import android.app.Application
import fr.stevenwatremez.kotlinwithdagger2.dagger.components.AppComponent
import fr.stevenwatremez.kotlinwithdagger2.dagger.components.DaggerAppComponent
import fr.stevenwatremez.kotlinwithdagger2.dagger.modules.AppModule

class KotlinWithDaggerApp : Application() {

  lateinit var appComponent: AppComponent
    private set

  override fun onCreate() {
    super.onCreate()
    appComponent = DaggerAppComponent
        .builder()
        .appModule(AppModule(this))
        .build()
  }
}
