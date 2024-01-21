package com.aos.hiltex.example1.model

import com.aos.hiltex.example1.factory.BaseFactory

data class Product (
    val price: Int = 0,
    val type: ProductType? = null,
    val madeBy: BaseFactory.Location,
    val madeTime: Long
)

enum class ProductType {
    CANDY, CHOCOLATE, COFFEE
}
