package com.example.data.mapper

import com.example.data.local.model.EntityModel
import com.example.domain.model.DomainModel

/**
 * Created by Nguyen Văn Lieu on 3/24/2020
 */
interface EntityMapper<DM : DomainModel, EM : EntityModel> {
    fun mapToDomain(entityModel: EM): DM

    fun mapToEntity(domainModel: DM): EM
}