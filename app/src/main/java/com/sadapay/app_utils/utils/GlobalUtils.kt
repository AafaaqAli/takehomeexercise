package com.sadapay.app_utils.utils

import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

object GlobalUtils {
    /**
     * Set this state using time only sync after 12 hours or approch 
     * */
    fun shouldSyncTrendingRepositories(): Boolean{
        return false
    }

    object DoesNetworkHaveInternet {
        fun execute(): Boolean {
            return try{
                val socket = Socket()
                socket.connect(InetSocketAddress("8.8.8.8", 53))
                socket.close()
                return true
            }catch (e: IOException){
                false
            }
        }
    }
}