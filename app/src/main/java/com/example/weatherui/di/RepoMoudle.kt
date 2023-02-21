package com.example.weatherui.di

import com.example.data.remote.ApiServies
import com.example.data.repo.WitherRepoImpmation
import com.example.domain.repo.WitherRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoMoudle {
    @Provides
    fun perovideRebo(apiServies: ApiServies):WitherRepo{
        return WitherRepoImpmation(apiServies)
    }
}