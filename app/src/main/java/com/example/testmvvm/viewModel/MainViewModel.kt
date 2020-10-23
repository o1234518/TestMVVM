package com.example.testmvvm.viewModel

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.testmvvm.model.DataModel


class MainViewModel {

    private var dataModel: DataModel = DataModel()

    var isLoading: ObservableBoolean = ObservableBoolean(false)
    val mData = ObservableField<String>()

    fun refresh() {
        isLoading.set(true)
        dataModel.retrieveData(object : DataModel.onDataReadyCallBack {
            override fun onDataReady(data: String) {
                mData.set(data)
                isLoading.set(false)
            }
        })
    }
}