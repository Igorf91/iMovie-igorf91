package com.igorf91.imovie

import android.app.Application
import com.igorf91.imovie.di.networkModule
import com.igorf91.imovie.di.repositoryModule
import com.igorf91.imovie.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("unused")
class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CustomApplication)
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }
    }
}