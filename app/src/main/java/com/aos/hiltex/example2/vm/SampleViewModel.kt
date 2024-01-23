package com.aos.hiltex.example2.vm

import androidx.lifecycle.*
import com.aos.hiltex.example2.db.AppDatabase
import com.aos.hiltex.example2.db.Memo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor(private val appDatabase: AppDatabase) : ViewModel() {
    private val _memoList = MutableLiveData<List<Memo>>()
    val memoList: LiveData<List<Memo>> get() = _memoList

    init {
        if (memoList.value == null) getAllItems()
    }

    /**
     * DB 에 저장된 모든 데이터를 가져와, LiveData(memoList) 를 초기화한다.
     */
    private fun getAllItems() = viewModelScope.launch(Dispatchers.IO) {
        appDatabase.memoDao().getAll().let { itemList ->
            _memoList.postValue(itemList)
        }
    }

    /**
     * DB 에 아이템을 저장한다.
     *
     * @param memo 저장하려는 아이템
     */
    fun addItem(memo: Memo) = viewModelScope.launch(Dispatchers.IO) {
        appDatabase.memoDao().insert(memo)
        getAllItems()
    }

    /**
     * DB 에 저장된 특정 아이템을 수정한다.
     *
     * @param newMemo 수정하려는 아이템
     */
    fun updateItem(newMemo: Memo) = viewModelScope.launch(Dispatchers.IO) {
        appDatabase.memoDao().update(newMemo)
        getAllItems()
    }

    /**
     * DB 에 저장된 특정 아이템을 삭제한다.
     *
     * @param memo 삭제하려는 아이템
     */
    fun deleteItem(memo: Memo) = viewModelScope.launch(Dispatchers.IO) {
        appDatabase.memoDao().delete(memo)
        getAllItems()
    }
}