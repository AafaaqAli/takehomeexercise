package com.sadapay.app_utils.utils.preference_datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import javax.inject.Inject


class PreferenceDataStoreOperations @Inject constructor(
    private val preferenceDataStore: DataStore<Preferences>,
) {
    /**
     * DO NOT CLEAR PREFERENCE UNTIL, NEED TO FLUSH ENTIRE APP'S DATA, OR RESET SYNC TIME
     * */
    private suspend fun clearAllPreference() {
        preferenceDataStore.edit { preferences ->
            preferences.clear()
        }
    }

    suspend fun resetSyncTime(preferenceName: String){
        val dataStoreKey = intPreferencesKey(preferenceName)
        preferenceDataStore.edit { preferences ->
            preferences.remove(dataStoreKey)
        }
    }


    /**
     * Save String
     * */
    suspend fun saveDataStorePreference(key: String, value: String){
        val dataStoreKey = stringPreferencesKey(key)
        preferenceDataStore.edit { appPreference ->
            appPreference[dataStoreKey] = value
        }
    }


    /**
     * Save Boolean
     * */
    suspend fun saveDataStorePreference(key: String, value: Boolean){
        val dataStoreKey = booleanPreferencesKey(key)
        preferenceDataStore.edit { appPreference ->
            appPreference[dataStoreKey] = value
        }
    }

    /**
     * Save Int
     * */
    suspend fun saveDataStorePreference(key: String, value: Int){
        val dataStoreKey = intPreferencesKey(key)
        preferenceDataStore.edit { appPreference ->
            appPreference[dataStoreKey] = value
        }
    }

    /**
     * Save Long
     * */
    suspend fun saveDataStorePreference(key: String, value: Long) {
        val dataStoreKey = longPreferencesKey(key)
        preferenceDataStore.edit { appPreference ->
            appPreference[dataStoreKey] = value
        }
    }
}