package com.aos.hiltex.example2

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.aos.hiltex.HiltApplication.Companion.TAG
import com.aos.hiltex.R
import com.aos.hiltex.databinding.ActivityMain2Binding
import com.aos.hiltex.example2.db.Memo
import com.aos.hiltex.example2.vm.SampleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private val sampleViewModel: SampleViewModel by viewModels()
    private lateinit var listAdapterEx: SampleListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)
        binding.mainActivity = this@MainActivity

        initRecyclerView()
        observeLiveData()
    }

    private fun initRecyclerView() {
        listAdapterEx = SampleListAdapter(itemClickListener = object : SampleListAdapter.ClickEventListener {
            override fun onModifyLongClicked(item: Memo) {
                Toast.makeText(this@MainActivity, "onLongClickEvent", Toast.LENGTH_SHORT).show()
            }
            override fun onModifyShortClicked(newItem: Memo) {
                sampleViewModel.updateItem(newItem)
            }
            override fun onDeleteClicked(item: Memo) {
                sampleViewModel.deleteItem(item)
            }
        })

        binding.recyclerView.apply {
            adapter = listAdapterEx
            setHasFixedSize(true)
        }
    }

    private fun observeLiveData() {
        //DB 데이터 -> RV 어댑터 전달
        sampleViewModel.memoList.observe(this@MainActivity) { memoList ->
            listAdapterEx.submitList(memoList)
        }
    }

    fun onSaveButtonClicked() {
        if (binding.editMemo.text.isNotEmpty()) {
            sampleViewModel.addItem(
                memo = Memo(
                    content = binding.editMemo.text.toString(),
                    dateTime = System.currentTimeMillis()
                )
            )
            binding.editMemo.text = null
        }
    }
}