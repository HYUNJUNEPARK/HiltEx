package com.aos.hiltex.di

import com.aos.hiltex.model.Product
import com.aos.hiltex.model.ProductType
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

interface BaseFoodFactory {
    fun makeCandy(): Product
    fun makeChocolate(): Product
    fun makeCoffee(): Product
}

@ActivityScoped
class FoodFactoryInLA @Inject constructor(): BaseFoodFactory {
    override fun makeCandy(): Product {
        return Product(
            price = 0,
            type = ProductType.CANDY,
            madeBy = null
        )
    }

    override fun makeChocolate(): Product {
        return Product(
            price = 0,
            type = ProductType.CHOCOLATE,
            madeBy = null
        )
    }

    override fun makeCoffee(): Product {
        return Product(
            price = 0,
            type = ProductType.COFFEE,
            madeBy = null
        )
    }
}

