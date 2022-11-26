package com.example.aroapp.utils

import android.content.Context
import com.example.aroapp.dataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

object AuthManager {
    var isLoggedIn: Boolean? = null
    private var accessKey: String? = null
    private var isConfiguring = false;

    fun configure(context: Context) {
        if(isConfiguring){
            return
        }

        isConfiguring = true
        val accessKeyFlow = context.dataStore.data.map {
            it[PreferenceKeys.accessKey]
        }
        CoroutineScope(Dispatchers.Main).launch {
            accessKeyFlow.collectLatest {
                accessKey = it
                isLoggedIn = it != null
            }
        }
    }
}