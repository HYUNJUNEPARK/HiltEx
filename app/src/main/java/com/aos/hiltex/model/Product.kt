package com.aos.hiltex.model

import com.aos.hiltex.enums.Location

data class Product (
    val price: Int = 0,
    val type: ProductType? = null,
    val madeBy: Location,
    val madeTime: Long
)

enum class ProductType {
    CANDY, CHOCOLATE, COFFEE
}
