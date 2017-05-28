package fr.stevenwatremez.kotlinwithdagger2.dagger.components

import dagger.Component
import fr.stevenwatremez.kotlinwithdagger2.dagger.modules.AppModule
import fr.stevenwatremez.kotlinwithdagger2.dagger.modules.NetModule
import fr.stevenwatremez.kotlinwithdagger2.dagger.modules.UtilsModule
import fr.stevenwatremez.kotlinwithdagger2.ui.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetModule::class, UtilsModule::class))
interface AppComponent {
  fun inject(activity: MainActivity)
  // fun inject(fragment: MyFragment);
  // fun inject(service: MyService);
}