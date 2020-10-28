package com.example.testmvvm.viewModel

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testmvvm.model.DataModel
import com.example.testmvvm.utils.SingleLiveEvent

class MainViewModel: ViewModel() {

    private var dataModel: DataModel = DataModel()

    var isLoading: ObservableBoolean = ObservableBoolean(false)
    val mData = MutableLiveData<String>()
    val toastText = SingleLiveEvent<String>()

    fun refresh() {
        isLoading.set(true)
        dataModel.retrieveData(object : DataModel.onDataReadyCallBack {
            override fun onDataReady(data: String) {
                mData.postValue(data)
                toastText.value = "下載完成"
                isLoading.set(false)
            }
        })
    }
}