package com.aos.hiltex.example1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.aos.hiltex.HiltApplication.Companion.TAG
import com.aos.hiltex.R
import com.aos.hiltex.databinding.ActivityMainBinding
import com.aos.hiltex.example1.di.InLA
import com.aos.hiltex.example1.di.InNY
import com.aos.hiltex.example1.factory.BaseFactory
import com.aos.hiltex.example1.factory.CarFactoryInLA
import com.aos.hiltex.example1.factory.FoodFactoryInLA
import com.aos.hiltex.example1.factory.FoodFactoryInNY
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @Inject lateinit var foodFactoryInLA: FoodFactoryInLA
    @Inject lateinit var foodFactoryInNY: FoodFactoryInNY

    @InLA
    @Inject lateinit var carFactoryInLA: BaseFactory.BaseCarFactory

    @InNY
    @Inject lateinit var carFactoryInNY: BaseFactory.BaseCarFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainActivity = this@MainActivity
    }

    fun onTestButtonClicked() {
        Toast.makeText(this, "TestButton", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "${foodFactoryInLA.makeCandy()}")
        Log.d(TAG, "${foodFactoryInLA.makeChocolate()}")
        Log.d(TAG, "${foodFactoryInLA.makeCoffee()}")

        Log.d(TAG, "=============================================")

        Log.d(TAG, "${foodFactoryInNY.makeCandy()}")
        Log.d(TAG, "${foodFactoryInNY.makeChocolate()}")
        Log.d(TAG, "${foodFactoryInNY.makeCoffee()}")

        Log.d(TAG, "=============================================")

        Log.d(TAG, carFactoryInLA.getMadeInfo())
        Log.d(TAG, carFactoryInNY.getMadeInfo())

    }
}