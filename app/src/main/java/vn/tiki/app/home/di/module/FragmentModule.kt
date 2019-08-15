package vn.tiki.app.home.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.tiki.app.home.screen.home.HomeFragment

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun bindHomeFragment (): HomeFragment
}
