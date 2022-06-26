package com.sadapay.app_utils.utils.preference_datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import kotlinx.coroutines.flow.first
import javax.inject.Inject


class PreferenceDataStoreOperations @Inject constructor(
    private val preferenceDataStore: DataStore<Preferences>,
) {

    /**
     * DO NOT CLEAR PREFERENCE UNTIL, NEED TO FLUSH ENTIRE APP'S DATA, OR RESET SYNC TIME
     * */
    suspend fun clearAllPreference() {
        preferenceDataStore.edit { preferences ->
            preferences.clear()
        }
    }

    suspend fun String.resetSyncTime(){
        val dataStoreKey = intPreferencesKey(this)
        preferenceDataStore.edit { preferences ->
            preferences.remove(dataStoreKey)
        }
    }


    /**
     * Save & Get String
     * */
    suspend fun String.saveDataStorePreference(key: String){
        val dataStoreKey = stringPreferencesKey(key)
        preferenceDataStore.edit { appPreference ->
            appPreference[dataStoreKey] = this
        }
    }

    suspend fun String.getDataStorePreference(): String?{
        val dataStoreKey = stringPreferencesKey(this)
        val preferences = preferenceDataStore.data.first()
        return preferences[dataStoreKey]
    }

    /**
     * Save Boolean
     * */
    suspend fun Boolean.saveDataStorePreference(key: String){
        val dataStoreKey = booleanPreferencesKey(key)
        preferenceDataStore.edit { appPreference ->
            appPreference[dataStoreKey] = this
        }
    }

    /**
     * Save Int
     * */
    suspend fun Int.saveDataStorePreference(key: String){
        val dataStoreKey = intPreferencesKey(key)
        preferenceDataStore.edit { appPreference ->
            appPreference[dataStoreKey] = this
        }
    }

    /**
     * Save Long
     * */
    suspend fun Long.saveDataStorePreference(key: String){
        val dataStoreKey = longPreferencesKey(key)
        preferenceDataStore.edit { appPreference ->
            appPreference[dataStoreKey] = this
        }
    }
}