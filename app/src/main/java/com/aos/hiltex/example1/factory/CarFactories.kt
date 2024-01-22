package com.aos.hiltex.example1.factory

import javax.inject.Inject

class CarFactoryInLA @Inject constructor() : BaseFactory.BaseCarFactory {
    override fun getMadeInfo(): String {
        return "LA"
    }
}

class CarFactoryInNY @Inject constructor() : BaseFactory.BaseCarFactory {
    override fun getMadeInfo(): String {
        return "NY"
    }
}