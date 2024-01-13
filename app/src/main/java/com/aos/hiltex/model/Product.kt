package com.aos.hiltex.model

data class Product (
    val price: Int = 0,
    val type: ProductType? = null,
    val madeBy: String? = null
)

enum class ProductType {
    CANDY, CHOCOLATE, COFFEE
}
