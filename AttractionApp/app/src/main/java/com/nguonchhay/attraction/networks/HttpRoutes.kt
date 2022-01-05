package com.nguonchhay.attraction.networks

object HttpRoutes {

    private const val BASE_URL = "https://nguonchhay.free.beeceptor.com"

    const val ATTRACTIONS = "$BASE_URL/api/attractions"
    const val ATTRACTIONS_SHOW = "$BASE_URL/api/attractions/{id}"
    const val USER_LOGIN = "$BASE_URL/api/login"
    const val USERS = "$BASE_URL/api/users"
}