package vn.tiki.app.home

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import vn.tiki.app.home.di.DaggerApplicationComponent

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().application(this).build().apply {
            inject(this@App)
        }
    }
}
