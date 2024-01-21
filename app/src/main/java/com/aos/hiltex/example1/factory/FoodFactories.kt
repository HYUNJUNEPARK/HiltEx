package com.aos.hiltex.example1.factory

import com.aos.hiltex.example1.model.Product
import com.aos.hiltex.example1.model.ProductType
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class FoodFactoryInLA @Inject constructor(
    private val materialFactory: MaterialFactoryInLA
): BaseFactory.BaseFoodFactory {

    override fun makeCandy(): Product {
        return Product(
            price = materialFactory.getSugar(),
            type = ProductType.CANDY,
            madeBy = BaseFactory.Location.LA,
            madeTime = materialFactory.getDeliveryTime()
        )
    }

    override fun makeChocolate(): Product {
        return Product(
            price = materialFactory.getKakao(),
            type = ProductType.CHOCOLATE,
            madeBy = BaseFactory.Location.LA,
            madeTime = materialFactory.getDeliveryTime()
        )
    }

    override fun makeCoffee(): Product {
        return Product(
            price = materialFactory.getCoffeeBean(),
            type = ProductType.COFFEE,
            madeBy = BaseFactory.Location.LA,
            madeTime = materialFactory.getDeliveryTime()
        )
    }
}

@ActivityScoped
class FoodFactoryInNY @Inject constructor(
    private val materialFactory: MaterialFactoryInNY
): BaseFactory.BaseFoodFactory {
    override fun makeCandy(): Product {
        return Product(
            price = materialFactory.getSugar(),
            type = ProductType.CANDY,
            madeBy = BaseFactory.Location.NY,
            madeTime = materialFactory.getDeliveryTime()
        )
    }

    override fun makeChocolate(): Product {
        return Product(
            price = materialFactory.getKakao(),
            type = ProductType.CANDY,
            madeBy = BaseFactory.Location.NY,
            madeTime = materialFactory.getDeliveryTime()
        )
    }

    override fun makeCoffee(): Product {
        return Product(
            price = materialFactory.getCoffeeBean(),
            type = ProductType.CANDY,
            madeBy = BaseFactory.Location.NY,
            madeTime = materialFactory.getDeliveryTime()
        )
    }
}
