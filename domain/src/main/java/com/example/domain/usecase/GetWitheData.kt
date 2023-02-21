package com.example.domain.usecase

import com.example.domain.repo.WitherRepo

class GetWitheData(private val witherRepo:WitherRepo) {
    suspend operator fun invoke() = witherRepo.getWitherFormRemote()
}