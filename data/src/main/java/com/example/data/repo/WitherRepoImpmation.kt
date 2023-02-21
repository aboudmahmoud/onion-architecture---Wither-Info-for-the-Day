package com.example.data.repo

import com.example.data.BuildConfig
import com.example.data.remote.ApiServies
import com.example.domain.entity.WitherInfo
import com.example.domain.repo.WitherRepo

class WitherRepoImpmation(private val apiServies: ApiServies): WitherRepo {
    override suspend fun getWitherFormRemote(): WitherInfo = apiServies.getWither(BuildConfig.API_KEY)
}