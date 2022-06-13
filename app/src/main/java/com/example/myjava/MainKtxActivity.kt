package com.example.myjava

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myjava.reflect.ViewModeDemo

class MainKtxActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//     var viewModeDemo = ViewModelProvider(this,object :ViewModelProvider.Factory{
//         override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//             return ViewModeDemo("test") as T
//         }
//     }).get(ViewModeDemo::class.java)
//
    }

   fun test(){
       lifecycle.addObserver(LifecycleObserver)

   }
}