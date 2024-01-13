package com.aos.hiltex.factory

import com.aos.hiltex.enums.Location
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
class FoodFactoryInLA @Inject constructor(
    private val materialFactory: MaterialFactoryInLA
): BaseFoodFactory {

    override fun makeCandy(): Product {
        return Product(
            price = materialFactory.getSugar(),
            type = ProductType.CANDY,
            madeBy = Location.LA
        )
    }

    override fun makeChocolate(): Product {
        return Product(
            price = materialFactory.getKakao(),
            type = ProductType.CHOCOLATE,
            madeBy = Location.LA
        )
    }

    override fun makeCoffee(): Product {
        return Product(
            price = materialFactory.getCoffeeBean(),
            type = ProductType.COFFEE,
            madeBy = Location.LA
        )
    }
}

@ActivityScoped
class FoodFactoryInNY @Inject constructor(
    private val materialFactory: MaterialFactoryInLNY
): BaseFoodFactory {
    override fun makeCandy(): Product {
        return Product(
            price = materialFactory.getSugar(),
            type = ProductType.CANDY,
            madeBy = Location.NY
        )
    }

    override fun makeChocolate(): Product {
        return Product(
            price = materialFactory.getKakao(),
            type = ProductType.CANDY,
            madeBy = Location.NY
        )
    }

    override fun makeCoffee(): Product {
        return Product(
            price = materialFactory.getCoffeeBean(),
            type = ProductType.CANDY,
            madeBy = Location.NY
        )
    }
}
