package com.aos.hiltex.example2

import com.aos.hiltex.example2.db.Memo

class ClickListener {
    interface ClickEventListener {
        fun onModifyLongClicked(item: Memo)
        fun onModifyShortClicked(newItem: Memo)
        fun onDeleteClicked(item: Memo)
    }
}