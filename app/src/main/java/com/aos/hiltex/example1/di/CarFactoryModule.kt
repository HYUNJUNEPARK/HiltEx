package com.aos.hiltex.example1.di

import com.aos.hiltex.example1.factory.BaseFactory
import com.aos.hiltex.example1.factory.CarFactoryInLA
import com.aos.hiltex.example1.factory.CarFactoryInNY
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class InLA

@Qualifier
annotation class InNY

@InstallIn(SingletonComponent::class)
@Module
abstract class CarFactoryInLAModule() {
    @InLA
    @Singleton
    @Binds
    abstract fun bindCarFactoryInLA(impl: CarFactoryInLA): BaseFactory.BaseCarFactory
}

@InstallIn(ActivityComponent::class)
@Module
abstract class CarFactoryModuleInNYModule() {
    @InNY
    @ActivityScoped
    @Binds
    abstract fun bindingCarInFactoryInNY(impl: CarFactoryInNY) : BaseFactory.BaseCarFactory
}





