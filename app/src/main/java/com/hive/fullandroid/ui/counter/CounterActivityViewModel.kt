package com.hive.fullandroid.ui.counter

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class CounterActivityViewModel : ViewModel(){
    private var counter = 0
    var counterLiveData = MutableLiveData<Int>()

    fun getInitialCounter() : MutableLiveData<Int>{
        counterLiveData.value = counter
        return counterLiveData
    }

    fun incrementCounter() {
        counter = counter.inc()
        counterLiveData.value = counter
    }

}
