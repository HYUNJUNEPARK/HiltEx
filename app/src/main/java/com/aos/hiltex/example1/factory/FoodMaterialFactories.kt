package com.aos.hiltex.example1.factory

import javax.inject.Inject

class MaterialFactoryInLA @Inject constructor() : BaseFactory.BaseMaterialFactory {
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

class MaterialFactoryInNY @Inject constructor(): BaseFactory.BaseMaterialFactory {
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