package com.example.data.mapper

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
interface Mapper<DM,DT> {
    fun mapToDomain(data:DT):DM
    fun mapToData(domain:DM):DT
}