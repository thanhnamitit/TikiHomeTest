package vn.tiki.app.home.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import vn.tiki.app.home.di.viewmodel.ViewModelFactory
import vn.tiki.app.home.di.viewmodel.ViewModelKey
import vn.tiki.app.home.screen.home.HomeViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel
}
