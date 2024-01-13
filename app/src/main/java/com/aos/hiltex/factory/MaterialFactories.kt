package com.aos.hiltex.factory

import javax.inject.Singleton

interface BaseMaterialFactory {
    fun getSugar(): Int
    fun getKakao(): Int
    fun getCoffeeBean(): Int
    fun getDeliveryTime(): Long
}

class MaterialFactoryInLA : BaseMaterialFactory {
    override fun getSugar(): Int {
        return 1000
    }

    override fun getKakao(): Int {
        return 1500
    }

    override fun getCoffeeBean(): Int {
        return 2000
    }

    override fun getDeliveryTime(): Long {
        return System.currentTimeMillis()
    }
}

class MaterialFactoryInNY : BaseMaterialFactory {
    override fun getSugar(): Int {
        return 1020
    }

    override fun getKakao(): Int {
        return 1520
    }

    override fun getCoffeeBean(): Int {
        return 2020
    }
    override fun getDeliveryTime(): Long {
        return System.currentTimeMillis()
    }
}