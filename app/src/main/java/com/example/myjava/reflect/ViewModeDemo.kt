package com.example.myjava.reflect

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModeDemo (var str:String):ViewModel(){

    var liveData = MutableLiveData<Int>()

}