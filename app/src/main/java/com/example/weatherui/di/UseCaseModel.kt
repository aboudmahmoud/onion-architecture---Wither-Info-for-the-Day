package com.example.weatherui.di

import com.example.domain.repo.WitherRepo
import com.example.domain.usecase.GetWitheData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModel {
    @Provides
    fun provideUseCase(withRebo: WitherRepo): GetWitheData{
        return GetWitheData(withRebo)
    }

}