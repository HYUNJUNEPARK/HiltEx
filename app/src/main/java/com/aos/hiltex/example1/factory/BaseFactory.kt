package com.aos.hiltex.example1.factory

import com.aos.hiltex.example1.model.Product

class BaseFactory {
    enum class Location {
        LA, NY
    }

    interface BaseFoodFactory {
        fun makeCandy(): Product
        fun makeChocolate(): Product
        fun makeCoffee(): Product
    }

    interface BaseMaterialFactory {
        fun getSugar(): Int
        fun getKakao(): Int
        fun getCoffeeBean(): Int
        fun getDeliveryTime(): Long
    }

    interface BaseCarFactory {
        fun getMadeInfo(): String
    }
}