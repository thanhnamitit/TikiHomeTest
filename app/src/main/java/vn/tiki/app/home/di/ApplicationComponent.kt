package vn.tiki.app.home.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import vn.tiki.app.home.App
import vn.tiki.app.home.di.module.FragmentModule
import vn.tiki.app.home.di.module.NetworkModule
import vn.tiki.app.home.di.module.UseCaseModule
import vn.tiki.app.home.di.module.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        FragmentModule::class,
        UseCaseModule::class
    ]

)
interface ApplicationComponent : AndroidInjector<App> {
    override fun inject(instance: App)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): ApplicationComponent.Builder

        fun build(): ApplicationComponent
    }
}
