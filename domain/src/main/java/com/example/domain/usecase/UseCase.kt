package com.example.domain.usecase

import io.reactivex.Observable

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
interface UseCase<in Param, T:Any> {
    fun execute(param: Param):Observable<T>
}

interface WithoutParamUseCase<T>{
    fun execute():Observable<T>
}