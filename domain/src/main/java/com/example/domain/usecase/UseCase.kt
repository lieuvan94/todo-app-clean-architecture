package com.example.domain.usecase

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
interface UseCase<in Param,out T> {
    fun execute(param: Param):T
}

interface WithoutParamUseCase<T>{
    fun execute():T
}