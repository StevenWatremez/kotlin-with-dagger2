package fr.stevenwatremez.kotlinwithdagger2.ui

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import fr.stevenwatremez.kotlinwithdagger2.R
import fr.stevenwatremez.kotlinwithdagger2.app.KotlinWithDaggerApp
import fr.stevenwatremez.kotlinwithdagger2.utils.StringFactory
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

  @Inject lateinit var cachedClient: OkHttpClient
  @Inject lateinit var sharedPreferences: SharedPreferences
  @Inject lateinit var stringFactory: StringFactory

  override fun onCreate(savedInstanceState: Bundle?) {
    (application as KotlinWithDaggerApp).appComponent.inject(this)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    main_text_view.text = stringFactory.kotlinAndDagger2
  }
}
