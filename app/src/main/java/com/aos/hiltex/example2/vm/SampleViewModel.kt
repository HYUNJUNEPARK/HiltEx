package com.aos.hiltex.example2.vm

import androidx.lifecycle.*
import com.aos.hiltex.example2.db.AppDatabase
import com.aos.hiltex.example2.db.Memo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SampleViewModel(private val appDatabase: AppDatabase) : ViewModel() {
    private val _memoList = MutableLiveData<List<Memo>>()
    val memoList: LiveData<List<Memo>> get() = _memoList

    init {
        if (memoList.value == null) getAllItems()
    }

    /**
     * DB 에 저장된 모든 데이터를 가져와, LiveData(memoList) 를 초기화한다.
     */
    private fun getAllItems() = CoroutineScope(Dispatchers.IO).launch {
        try {
            appDatabase.memoDao().getAll().let { itemList ->
                _memoList.postValue(itemList)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * DB 에 아이템을 저장한다.
     *
     * @param memo 저장하려는 아이템
     */
    fun addItem(memo: Memo) = CoroutineScope(Dispatchers.IO).launch {
        try {
            appDatabase.memoDao().insert(memo)
            getAllItems() //데이터 동기화
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * DB 에 저장된 특정 아이템을 수정한다.
     *
     * @param newMemo 수정하려는 아이템
     */
    fun updateItem(newMemo: Memo) = CoroutineScope(Dispatchers.IO).launch {
        try {
            appDatabase.memoDao().update(newMemo)
            getAllItems() //데이터 동기화
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    /**
     * DB 에 저장된 특정 아이템을 삭제한다.
     *
     * @param memo 삭제하려는 아이템
     */
    fun deleteItem(memo: Memo) = CoroutineScope(Dispatchers.IO).launch {
        try {
            appDatabase.memoDao().delete(memo)
            getAllItems() //데이터 동기화
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    class Factory(private val appDatabase: AppDatabase): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SampleViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return SampleViewModel(appDatabase) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}