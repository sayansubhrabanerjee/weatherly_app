package sayan.banerjee.weatherly.common.network.listener

interface INetworkListener {
    fun onConnectivityChange(connectionStatus: String)
}