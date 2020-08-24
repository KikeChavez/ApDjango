package com.example.appdjango

class FootRepository(
    private val api: FootApi
) : SafeApiRequest() {
    suspend fun getMenu() = apiRequest { api.getMenu() }
}