package com.hiltdemo

import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers(): Response<List<User>>
}