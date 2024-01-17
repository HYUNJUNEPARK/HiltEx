package com.aos.hiltex.example1.di

import com.aos.hiltex.example1.factory.MaterialFactoryInLA
import com.aos.hiltex.example1.factory.MaterialFactoryInNY
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object FactoryModule {

    @Provides
    fun provideMaterialFactoryInLA(): MaterialFactoryInLA {
        return MaterialFactoryInLA()
    }

    @Provides
    fun provideMaterialFactoryInNY(): MaterialFactoryInNY {
        return MaterialFactoryInNY()
    }
}