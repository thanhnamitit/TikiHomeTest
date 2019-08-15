package vn.tiki.app.home.di.module

import dagger.Module
import dagger.Provides
import vn.tiki.app.home.data.repository.remote.ApiRepository
import vn.tiki.app.home.data.repository.remote.usecase.FetchKeywordsUseCase

@Module
class UseCaseModule {
    @Provides
    fun provideFetchKeywordsUseCase(repository: ApiRepository): FetchKeywordsUseCase {
        return FetchKeywordsUseCase(repository)
    }
}
