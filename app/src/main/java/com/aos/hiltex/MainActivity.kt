package com.aos.hiltex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.aos.hiltex.HiltApplication.Companion.TAG
import com.aos.hiltex.databinding.ActivityMainBinding
import com.aos.hiltex.factory.FoodFactoryInLA
import com.aos.hiltex.factory.FoodFactoryInNY
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @Inject lateinit var foodFactoryInLA: FoodFactoryInLA
    @Inject lateinit var foodFactoryInNY: FoodFactoryInNY

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

        Log.d(TAG, "${foodFactoryInNY.makeCandy()}")
        Log.d(TAG, "${foodFactoryInNY.makeChocolate()}")
        Log.d(TAG, "${foodFactoryInNY.makeCoffee()}")
    }
}