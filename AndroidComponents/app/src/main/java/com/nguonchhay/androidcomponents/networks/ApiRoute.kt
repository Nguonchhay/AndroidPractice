package com.nguonchhay.androidcomponents.networks

object ApiRoute {
    const val BASE_URL = "https://nguonchhay.free.beeceptor.com"
    const val API_MINIONS_LIST = "${BASE_URL}/api/minions"
    const val API_MINIONS_UPDATE = "${API_MINIONS_LIST}/{id}/update"
}