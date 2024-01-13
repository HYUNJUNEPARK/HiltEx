package com.aos.hiltex.factory

import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

interface BaseMaterialFactory {
    fun getSugar(): Int
    fun getKakao(): Int
    fun getCoffeeBean(): Int
}

@ActivityScoped
class MaterialFactoryInLA @Inject constructor() : BaseMaterialFactory {
    override fun getSugar(): Int {
        return 1000
    }

    override fun getKakao(): Int {
        return 1500
    }

    override fun getCoffeeBean(): Int {
        return 2000
    }
}

@ActivityScoped
class MaterialFactoryInLNY @Inject constructor(): BaseMaterialFactory {
    override fun getSugar(): Int {
        return 1020
    }

    override fun getKakao(): Int {
        return 1520
    }

    override fun getCoffeeBean(): Int {
        return 2020
    }
}