package com.example.aroapp

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.aroapp.utils.AuthManager
import dagger.hilt.android.HiltAndroidApp

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "prefs")

@HiltAndroidApp
class AROApp: Application() {
    override fun onCreate() {
        super.onCreate()
        AuthManager.configure(this)
    }
}