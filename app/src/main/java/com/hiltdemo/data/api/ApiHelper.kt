package com.hiltdemo.data.api

import com.hiltdemo.data.model.User
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers(): Response<List<User>>
}