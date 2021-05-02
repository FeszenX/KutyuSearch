package com.example.kutyusearch

//import android.content.Context
//import com.example.kutyusearch.ui.breads.BreadsPresenter
//import dagger.Provides
//import java.util.concurrent.Executor
//import javax.inject.Singleton
//
//class TestModule(private val context: Context) {
//
//    @Provides
//    fun provideContext() = context
//
//    @Provides
//    @Singleton
//    fun provideBreadPresenter() = BreadsPresenter()
//
//    @Provides
//    @Singleton
//    fun provideArtistsPresenter(executor: Executor, artistsInteractor: ArtistsInteractor) = ArtistsPresenter(executor, artistsInteractor)
//
//    @Provides
//    @Singleton
//    fun provideNetworkExecutor(): Executor = UiExecutor()
//}