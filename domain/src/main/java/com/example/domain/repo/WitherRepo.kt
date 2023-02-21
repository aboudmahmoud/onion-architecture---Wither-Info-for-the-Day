package com.example.domain.repo

import com.example.domain.entity.WitherInfo

interface WitherRepo {
   suspend fun getWitherFormRemote() : WitherInfo
}