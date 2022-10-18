package com.sagen.demo.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sagen.demo.DemoApplication
import com.sagen.demo.R
import com.sagen.demo.data.model.CollectionResp
import com.sagen.demo.di.module.ViewModelModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as DemoApplication).appComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        getCollectionDataByUserId("KS0003")
    }


    private fun getCollectionDataByUserId(userId: String) {
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.getCollectionDataByUserId(userId)
                .observe(this@MainActivity) { collectionResp ->

                    if (collectionResp.collectionInputDtoList.isNotEmpty()) {
                        Log.v(TAG, "Collection Resp $collectionResp")
                     saveIntoLocalDatasource(collectionResp)
                    }
                }
        }

    }

    private fun saveIntoLocalDatasource(collectionResp: CollectionResp) {
        CoroutineScope(Dispatchers.Main).launch { viewModel.saveIntoLocalDatasource(collectionResp.collectionInputDtoList) }


    }
}