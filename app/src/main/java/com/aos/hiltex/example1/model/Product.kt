package com.aos.hiltex.example1.model

import com.aos.hiltex.example1.enums.Location

data class Product (
    val price: Int = 0,
    val type: ProductType? = null,
    val madeBy: Location,
    val madeTime: Long
)

enum class ProductType {
    CANDY, CHOCOLATE, COFFEE
}
