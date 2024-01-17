package com.aos.hiltex.example1.factory

import com.aos.hiltex.example1.enums.Location
import com.aos.hiltex.example1.model.Product
import com.aos.hiltex.example1.model.ProductType
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

interface BaseFoodFactory {
    fun makeCandy(): Product
    fun makeChocolate(): Product
    fun makeCoffee(): Product
}

@ActivityScoped
class FoodFactoryInLA @Inject constructor(
    private val materialFactory: MaterialFactoryInLA
): BaseFoodFactory {

    override fun makeCandy(): Product {
        return Product(
            price = materialFactory.getSugar(),
            type = ProductType.CANDY,
            madeBy = Location.LA,
            madeTime = materialFactory.getDeliveryTime()
        )
    }

    override fun makeChocolate(): Product {
        return Product(
            price = materialFactory.getKakao(),
            type = ProductType.CHOCOLATE,
            madeBy = Location.LA,
            madeTime = materialFactory.getDeliveryTime()
        )
    }

    override fun makeCoffee(): Product {
        return Product(
            price = materialFactory.getCoffeeBean(),
            type = ProductType.COFFEE,
            madeBy = Location.LA,
            madeTime = materialFactory.getDeliveryTime()
        )
    }
}

@ActivityScoped
class FoodFactoryInNY @Inject constructor(
    private val materialFactory: MaterialFactoryInNY
): BaseFoodFactory {
    override fun makeCandy(): Product {
        return Product(
            price = materialFactory.getSugar(),
            type = ProductType.CANDY,
            madeBy = Location.NY,
            madeTime = materialFactory.getDeliveryTime()
        )
    }

    override fun makeChocolate(): Product {
        return Product(
            price = materialFactory.getKakao(),
            type = ProductType.CANDY,
            madeBy = Location.NY,
            madeTime = materialFactory.getDeliveryTime()
        )
    }

    override fun makeCoffee(): Product {
        return Product(
            price = materialFactory.getCoffeeBean(),
            type = ProductType.CANDY,
            madeBy = Location.NY,
            madeTime = materialFactory.getDeliveryTime()
        )
    }
}
